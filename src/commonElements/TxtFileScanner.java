package commonElements;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TxtFileScanner {
    public ArrayList<Integer> dataScanned = new ArrayList<>();
    public boolean fileIsEmpty = false;
    public TxtFileScanner(String fileName) throws FileNotFoundException {
        File fileToScan = new File(fileName);
        if(fileToScan.canRead()){
        fileIsEmpty = false;
        Scanner txtScanner = new Scanner(fileToScan);
        while(txtScanner.hasNext()){
            if(txtScanner.hasNextInt()) {
                dataScanned.add(txtScanner.nextInt());
            } else {
                String tempInputString;
                tempInputString = txtScanner.next();
                int tempInputInt = Integer.parseInt(tempInputString);
                dataScanned.add(tempInputInt);
            }
        }
        } else {
            CreateNewFile newFileCreated = new CreateNewFile(fileName);
            fileIsEmpty = true;
        }
    }
}
