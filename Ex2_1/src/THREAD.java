import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class THREAD extends Thread {

    private String fileName;
    private int numLines;

    public THREAD(String fileName) {
        this.fileName = fileName;
        this.numLines = 0;
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numLines++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumLines() {
        return numLines;
    }
}
