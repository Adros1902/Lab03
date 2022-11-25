package commonElements;

import java.util.Scanner;

public class UserInputScanner {
    String dataStringScanned;
    int dataIntScanned;

    public String inputStringScanner(){
        Scanner txtScanner = new Scanner(System.in);
        dataStringScanned = txtScanner.next();
        return dataStringScanned;
    }
    public int inputIntScanner(){
        Scanner txtScanner = new Scanner(System.in);
        dataIntScanned = txtScanner.nextInt();
        return dataIntScanned;
    }
}
