package kucharzApp;

import commonElements.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.*;

public class KucharzApp {
    public static void main(String[] args) throws IOException {
        ClockTime clock = new ClockTime();
        int currentTime = clock.refresh();
        System.out.println("sus");
        ArrayList<Integer> clientsId = new ArrayList<>();
        ArrayList<Integer> ordersToMake = new ArrayList<>();
        ArrayList<Integer> ordersToMakeUpdated = new ArrayList<>();
        TxtFileScanner txtFileScanner = new TxtFileScanner();
        txtFileScanner.txtIntFileScanner("clientsId.txt");
        HashMap<Integer, String> ordersHashMap = new HashMap<>();

        for (int i = 0; i < txtFileScanner.dataScanned.size(); i++) {
            clientsId.add(txtFileScanner.dataScanned.get(i));
        }
        System.out.println("Aby dodac czas wpisz 'add'");
        String userInputTime;
        UserInputScanner userInputScanner = new UserInputScanner();
        userInputTime = userInputScanner.inputStringScanner();
        if (Objects.equals(userInputTime, "add")) {
            clock.addTime();
            currentTime = clock.refresh();
        }
        TxtFileScanner txtFileScannerOrder = new TxtFileScanner();
        txtFileScannerOrder.txtIntFileScanner("ordersToMake.txt");
        for (int i = 0; i < txtFileScannerOrder.dataScanned.size(); i++) {
            ordersToMake.add(txtFileScannerOrder.dataScanned.get(i));
            int temp = i + 1;
            String fileOrderName = temp + "_order.txt";
            ordersHashMap.put(temp, fileOrderName);
        }
        System.out.println(ordersToMake + "belize");
        System.out.println(ordersHashMap + "maroko");


        while (true) {
            System.out.println("Aby odswiezyc czas wpisz 'refresh', 'add'");
            String refresh = userInputScanner.inputStringScanner();
            boolean refreshStatus = true;
            if (Objects.equals(refresh, "refresh")) {
                currentTime = clock.refresh();
                refreshStatus = true;
            } else if (Objects.equals(refresh,"add")) {
                clock.addTime();
                currentTime= clock.refresh();
                refreshStatus = true;

            }
            while (refreshStatus) {
                TxtFileScanner txtFileScannerOrder1 = new TxtFileScanner();
                txtFileScannerOrder1.txtIntFileScanner("ordersToMake.txt");
                for (int i = 0; i < txtFileScannerOrder1.dataScanned.size(); i++) {
                    ordersToMakeUpdated.add(i, txtFileScannerOrder1.dataScanned.get(i));
                    System.out.println(ordersToMakeUpdated + "apap22");
                }
                //sprawdza czy doszły nowe zamówienia...
                if (!ordersToMakeUpdated.equals(ordersToMake)) {
                    int latestOldOrder = Collections.max(ordersToMake);
                    System.out.println("penis");
                    for (Integer newOrder : ordersToMakeUpdated) {
                        if (newOrder > latestOldOrder) {
                            ordersToMake.add(newOrder);
                            System.out.println("masa");
                            String fileOrderName = newOrder + "_order.txt";
                            ordersHashMap.put(newOrder, fileOrderName);
                            System.out.println();
                        }
                    }
                    refreshStatus = false;

                } else refreshStatus = false;
            }
            System.out.println("Zamowienia do zrobienia:");
            for (int i = 0; i < ordersToMake.size(); i++) {
                System.out.println(ordersToMake.get(i));
            }
            System.out.println("Wybierz zamowienie do przygotowania:");
            int pickedOrder = userInputScanner.inputIntScanner();
            TxtFileScanner orderScanner = new TxtFileScanner();
            orderScanner.txtIntFileScanner(ordersHashMap.get(pickedOrder));
            System.out.println(ordersHashMap.get(pickedOrder));
            MenuFileScanner menuFileScanner = new MenuFileScanner("menu.txt");
            System.out.println(menuFileScanner.getMenuElementsData());

            System.out.println(orderScanner.dataScanned + "argentyna");
            int orderStartTime = orderScanner.dataScanned.get(0);
            HashMap<Integer, MenuElement> menuFoodList = new HashMap<>();
            for (int i = 0; i < menuFileScanner.menuElementsData.size(); i++) {
                menuFoodList.put(i + 1, menuFileScanner.menuElementsData.get(i));
            }
            ArrayList<Integer> orderedFoodList = new ArrayList<>();
            for (int i = 1; i < orderScanner.dataScanned.size(); i++) {
                orderedFoodList.add(orderScanner.dataScanned.get(i));
            }
            System.out.println(orderedFoodList);
            Collections.sort(orderedFoodList);
            System.out.println(orderedFoodList);
            int orderTimeNeeded = 0;
            for (int i = 0; i < orderedFoodList.size(); i++) {
                for (Entry<Integer, MenuElement> entry : menuFoodList.entrySet()) {
                    if (Objects.equals(orderedFoodList.get(i), entry.getKey())) {
                        System.out.println("proba nr" + i);
                        System.out.println(entry.getKey() + "klucz");
                        orderTimeNeeded += menuFoodList.get(entry.getKey()).getTimeToMake();
                        System.out.println(orderTimeNeeded);
                    }
                }
            }
            System.out.println("czas:" + currentTime);
            System.out.println("odswiez lub dodaj czas:");
            String refreshStatus1 = userInputScanner.inputStringScanner();
            if (refreshStatus1 == "refresh") {
                clock.refresh();
            }
            if (Objects.equals(refreshStatus1, "add")) {
                clock.addTime();
                currentTime = clock.refresh();
            }
            int orderTimeReady = orderStartTime + orderTimeNeeded;
            System.out.println("Czas:" + currentTime);
            boolean isOrderReady = false;
            if (orderTimeReady <= currentTime) {
                isOrderReady = true;
            }
            while (!isOrderReady) {
                System.out.println("odswiez lub dodaj czas:");
                String refreshStatus3 = userInputScanner.inputStringScanner();
                if (Objects.equals(refreshStatus3, "refresh")) {
                    currentTime = clock.refresh();
                }
                if (Objects.equals(refreshStatus3, "add")) {
                    clock.addTime();
                    currentTime = clock.refresh();

                }
                System.out.println("Czas:" + currentTime);
                System.out.println(orderTimeReady + "czas na zamowienie");

                if (orderTimeReady <= currentTime) {
                    System.out.println("zamowienie jest gotowe");
                    int timeTookToMake = currentTime - orderStartTime;

                    TxtFileScanner orderChangeTimeScanner = new TxtFileScanner();
                    orderChangeTimeScanner.txtIntFileScanner(ordersHashMap.get(pickedOrder));
                    orderChangeTimeScanner.dataScanned.set(0, timeTookToMake);
                    TxtIntFileWriter orderChangeTimeWrite = new TxtIntFileWriter();
                    orderChangeTimeWrite.clearFile(ordersHashMap.get(pickedOrder));
                    for (int i = 0; i < orderChangeTimeScanner.dataScanned.size(); i++) {
                        orderChangeTimeWrite.writeInt(ordersHashMap.get(pickedOrder), orderChangeTimeScanner.dataScanned.get(i));
                    }
                    TxtIntFileWriter readyOrderWrite = new TxtIntFileWriter();
                    readyOrderWrite.writeInt("readyOrders.txt", pickedOrder);
                    ordersHashMap.remove(pickedOrder);
                    isOrderReady = true;
                } else continue;
                System.out.println(orderTimeNeeded);
            }
        }
    }
}