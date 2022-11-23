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
    public void addTime() throws IOException {
        TxtIntFileScanner scannerTime = new TxtIntFileScanner("clock.txt");
        FileWriter writeTime = new FileWriter("clock.txt",true);

        writeTime.write(String.valueOf(scannerTime.dataScanned.size()+1));
        writeTime.write(System.lineSeparator());
        writeTime.close();
    }
    public int updateTime() throws FileNotFoundException {
        TxtIntFileScanner scannerTime = new TxtIntFileScanner("clock.txt");
        int currentTime = Collections.max(scannerTime.dataScanned);
        return currentTime;
    }
}
