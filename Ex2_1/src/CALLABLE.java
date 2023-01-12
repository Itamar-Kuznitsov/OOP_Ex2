import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

public class CALLABLE implements Callable {

    private String name;

    public CALLABLE(String name) {
        this.name = name;
    }

    /**
     * Count the lines in the file
     * @return The number of lines in the file

     */
    @Override
    public Integer call() throws Exception {
        int linesCount = 0;
        try {
            FileReader fr = new FileReader(this.name);
            BufferedReader br = new BufferedReader(fr);
            while (br.readLine() != null) {
                linesCount++;
            }

            br.close();
        } catch (IOException ex) {
            System.out.print("Error reading file\n" + ex);
            System.exit(2);
        }
        return linesCount;
    }

}
