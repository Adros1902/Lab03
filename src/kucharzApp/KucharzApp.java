package kucharzApp;

import commonElements.*;

import java.util.ArrayList;
import java.util.Objects;

public class KucharzApp {
    public static void main(String[] args){
        ClockTime clock = new ClockTime();
        System.out.println("sus");
        ArrayList<Integer> clientsId = new ArrayList<>();
        ArrayList<Integer> ordersToMake = new ArrayList<>();
        ArrayList<Integer> ordersToMakeUpdated = new ArrayList<>();
        TxtFileScanner txtFileScanner = new TxtFileScanner();
        txtFileScanner.txtIntFileScanner("clientsId.txt");

        for(int i=0;i<txtFileScanner.dataScanned.size();i++) {
            clientsId.add(txtFileScanner.dataScanned.get(i));
        }
        System.out.println("Aby dodac czas wpisz 'minuta'");
        String userInputTime;
        UserInputScanner userInputScanner = new UserInputScanner();
        userInputTime = userInputScanner.inputStringScanner();
        if(Objects.equals(userInputTime,"minuta")){
            clock.addTime();
        }
        TxtFileScanner txtFileScannerOrder = new TxtFileScanner();
        txtFileScannerOrder.txtIntFileScanner("ordersToMake.txt");
        for(int i=0;i<txtFileScannerOrder.dataScanned.size();i++) {
            ordersToMake.add(txtFileScannerOrder.dataScanned.get(i));
        }
        System.out.println("Abu odswierzyc czas wpisz 'refresh'");
        String refresh = userInputScanner.inputStringScanner();
        boolean refreshStatus = true;
        if(Objects.equals(refresh,"refresh")){
            refreshStatus = true;
        }
        while(refreshStatus){
            TxtFileScanner txtFileScannerOrder1 = new TxtFileScanner();
            txtFileScannerOrder1.txtIntFileScanner("ordersToMake.txt");
            for(int i=0;i<txtFileScannerOrder1.dataScanned.size();i++) {
                ordersToMakeUpdated.add(txtFileScannerOrder1.dataScanned.get(i));
            }
            //sprawdza czy doszły nowe zamówienia...
        }
    }
}
