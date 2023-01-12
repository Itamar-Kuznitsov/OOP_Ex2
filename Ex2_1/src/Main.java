import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException  {

        long start, end;
        int count;
        System.out.println("RUNNING TIMES COMPARISON OF METHODS FOR CALCULATING THE NUMBER OF LINES :");
        String[] s = createTextFiles(5000, 2, 10000);
        start = System.currentTimeMillis();
        count = getNumOfLines(s);
        end = System.currentTimeMillis() - start;
        System.out.println("NORMAL METHOD      - Calculated : " + count + " Lines *** Time: " + end + " ms \n");

        start = System.currentTimeMillis();
        count = getNumOfLinesThreads(s);
        end = System.currentTimeMillis() - start;
        System.out.println("THREAD METHOD      - Calculated : " + count + " Lines *** Time: " + end + " ms \n");

        start = System.currentTimeMillis();
        count = getNumOfLinesThreadPool(s);
        end = System.currentTimeMillis() - start;
        System.out.println("THREAD-POOL METHOD - Calculated : " + count + " Lines *** Time: " + end + " ms \n");


    }
}
