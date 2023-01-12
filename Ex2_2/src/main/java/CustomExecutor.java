import java.util.concurrent.*;
public class CustomExecutor extends ThreadPoolExecutor{
    // min & max available cores for JVM:
    private static int minimumPoolSize = Runtime.getRuntime().availableProcessors()/2;
    private static int maximumPoolSize = Runtime.getRuntime().availableProcessors()- 1;
    private int[] priorities= new int[10];

    /**
     * CustomExecutor's Constructor extends from ThreadPoolExecutor
     */
    public CustomExecutor() {
        super(minimumPoolSize,
                maximumPoolSize,
                300L,
                TimeUnit.SECONDS,
                new PriorityBlockingQueue<>());
    }

    /**
     * function that responsible for shutdown the Thread pool.
     */
    public void gracefullyTerminate() {
        super.shutdown();
        try {
            super.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *  function for receiving the current maximum priority.
     * @return the maximum priority
     */
    public int getCurrentMax() {
        for(int i= 0;i<10;i++){
            if(this.priorities[i] != 0){
                return i+1;
            }
        }
        return 0;
    }

    /**
     * function that update the priorities tracking.
     * @param t the thread that will run task {@code r}
     * @param r the task that will be executed
     */
    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        CustomFutureTask r1 = (CustomFutureTask) r;
        this.priorities[r1.getPriority()-1] -= 1;
    }

    /**
     * function that create a new task.
     * @param t
     * @return new Task
     * @param <T>
     */
    protected <T> CustomFutureTask<T> newTask(Task t) {
        return new CustomFutureTask<T>(t.getCall(), t.getPriority());
    }

    /**
     * function that receive Task and execute it.
     * @param task
     * @return
     * @param <T>
     */
    public <T> Future<T> raw_submit(Task task) {
        if (task == null) throw new NullPointerException();
        this.priorities[task.getPriority()-1] += 1;
        CustomFutureTask<T> tTask = newTask(task);
        execute(tTask);
        return tTask;
    }

    /**
     * function that receive Callable<T> myFunc, TaskType type and execute them using submitTask.
     * @param myFunc
     * @param type
     * @return
     * @param <T>
     */
    public <T> Future<T> submit(Callable<T> myFunc, TaskType type) {
        if (myFunc == null || type == null) throw new NullPointerException();
        return raw_submit(Task.createTask(myFunc, type));
    }

    /**
     * function that receive Callable<T> myFunc and execute it using submitTask.
     * @param myFunc the task to submit
     * @return
     * @param <T>
     */
    public <T> Future<T> submit(Callable<T> myFunc) {
        if (myFunc == null) throw new NullPointerException();
        return raw_submit(Task.createTask(myFunc));
    }


public class CustomFutureTask<V> extends FutureTask<V> implements Comparable<CustomFutureTask> {
    private int priority;

    /**
     * CustomFutureTask's Constructor extends from FutureTask
     * @param call
     * @param priority
     */
    public CustomFutureTask(Callable<V> call, int priority) {
        super(call);
        this.priority = priority;
    }

    /**
     * function that get the priority
     * @return priority
     */
    public int getPriority(){
        return this.priority;
    }

    /**
     * toString function.
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() + String.valueOf(" Priority: "+getPriority());
    }
    public String printPriority()
    {
        return String.valueOf(this.priority);
    }

    /**
     * function that compare between priorities.
     * @param o the object to be compared.
     * @return 1,0,-1
     */
    @Override
    public int compareTo(CustomFutureTask o) {
        if (this.priority > o.getPriority())
            return 1;
        else if (this.priority < o.getPriority())
            return -1;
        return 0;
    }
}

}
