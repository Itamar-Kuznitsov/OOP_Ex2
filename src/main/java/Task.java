import java.util.concurrent.Callable;

public class Task<T> implements Callable<T>{
    private TaskType priority;
    private Callable<T> task;

    /**
     *  Task Constructor:
     *  as requested, we build Task comparable using TaskType enum priority.
     */
    private Task(Callable<T> task, TaskType priority) {
        this.priority = priority;
        this.task = task;
    }
    // Task Constructor without priority
    private Task(Callable<T> task) {
        this.priority = TaskType.IO;
        this.task = task;
    }

    /**
     * function that create a new Task receiving Callable, TaskType.
     * @param o
     * @param computational
     * @return Task
     */
    public static Task createTask(Callable<?> o, TaskType computational) {
        return new Task(o, computational);
    }
    /**
     * function that create a new Task receiving Callable.
     * @param o
     * @return Task
     */
    public static Task createTask(Callable<?> o) {
        return new Task(o);
    }

    /**
     * function that get the priority
     * @return priority
     */
    public int getPriority(){
        return this.priority.getPriorityValue();
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public T call() throws Exception {
        return this.task.call();
    }

    /**
     * function that return the task
     * @return Callable task
     * @param <T>
     */
    public <T> Callable<T> getCall(){
        return (Callable<T>) this.task;
    }

    /**
     * function that check if two tasks are equal.
     * @param obj
     * @return true/ false
     */
    @Override
    public boolean equals(Object obj) {
        return this.task.equals(obj);
    }

    /**
     * function that return the hashCode of a task
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return this.task.hashCode();
    }

}
