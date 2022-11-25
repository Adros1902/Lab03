package commonElements;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

public class ClockTime {


    public void clock() throws IOException {
        new CreateNewFile("clock.txt");
        FileWriter writeTime = new FileWriter("clock.txt");
        writeTime.write(String.valueOf(0));
        writeTime.write(System.lineSeparator());
        writeTime.close();
    }
    public void addTime() {
        TxtFileScanner scannerTime = new TxtFileScanner();
        scannerTime.txtIntFileScanner("clock.txt");
        FileWriter writeTime = null;
        try {
            writeTime = new FileWriter("clock.txt",true);
            writeTime.write(String.valueOf(scannerTime.dataScanned.size()));
            writeTime.write(System.lineSeparator());
            writeTime.close();
            refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public int refresh() throws FileNotFoundException {
        TxtFileScanner scannerTime = new TxtFileScanner();
        scannerTime.txtIntFileScanner("clock.txt");
        int currentTime = Collections.max(scannerTime.dataScanned);
        return currentTime;
    }
}
