package sprzedawcaApp;

import commonElements.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class SprzedawcaApp {
    public static void main(String[] args) throws IOException {
        ClockTime clock = new ClockTime();
        int oldTime = 0;
        HashMap<Integer, String> readyOrdersHashMap = new HashMap<>();
        int currentTime = clock.refresh();
        HashMap<Integer,MenuElement> menuFoodMap = new HashMap<>();
        MenuFileScanner menuFileScanner = new MenuFileScanner("menu.txt");
        for (int i = 0; i < menuFileScanner.menuElementsData.size(); i++) {
            menuFoodMap.put(i + 1, menuFileScanner.menuElementsData.get(i));
        }
        System.out.println("sussy baka");
        System.out.println("refresh or add");

        TxtFileScanner fileScanner = new TxtFileScanner();
        ArrayList<Integer> readyOrders = new ArrayList<>();
        fileScanner.txtIntFileScanner("readyOrders.txt");
        for(int i=0;i<fileScanner.dataScanned.size();i++) {
            readyOrders.add(fileScanner.dataScanned.get(i));
            int temp = i+1;
            String fileOrderName = temp+"_order.txt";
            readyOrdersHashMap.put(temp,fileOrderName);
        }

        while(true){
        UserInputScanner userInputScanner = new UserInputScanner();
        String userInput = userInputScanner.inputStringScanner();
        if(Objects.equals(userInput,"refresh")){
            currentTime = clock.refresh();
        } else if (Objects.equals(userInput,"add")) {
            clock.addTime();
            currentTime = clock.refresh();
        }



        while(oldTime != currentTime){
            ArrayList<Integer> readyOrdersUpdated = new ArrayList<>();
            TxtFileScanner scannerUpdatedReadyOrder = new TxtFileScanner();
            scannerUpdatedReadyOrder.txtIntFileScanner("readyOrders.txt");
            for (int i = 0; i < scannerUpdatedReadyOrder.dataScanned.size(); i++) {
                readyOrdersUpdated.add(i, scannerUpdatedReadyOrder.dataScanned.get(i));
                System.out.println(readyOrdersUpdated + "apap22");
            }
            if (!readyOrdersUpdated.equals(readyOrders)) {
                int latestOldOrder = Collections.max(readyOrders);
                System.out.println("penis");
                for (Integer newOrder : readyOrdersUpdated) {
                    if (newOrder > latestOldOrder) {
                        readyOrders.add(newOrder);
                        System.out.println("masa");
                        String fileOrderName = newOrder + "_order.txt";
                        readyOrdersHashMap.put(newOrder, fileOrderName);
                        System.out.println();
                    }
                    }
                }
            System.out.println("Gotowe zamowienia:");
            for (int i = 0; i < readyOrders.size(); i++) {
                System.out.println(readyOrders.get(i));
            }

            System.out.println("Wybierz zamowienie do wydania");
            int pickedOrder = userInputScanner.inputIntScanner();

            TxtFileScanner orderScanner = new TxtFileScanner();
            orderScanner.txtIntFileScanner(readyOrdersHashMap.get(pickedOrder));
            int timeTookToMake = orderScanner.dataScanned.get(0);
            ArrayList<Integer> orderedFood = new ArrayList<>();
            for(int i=1;i<orderScanner.dataScanned.size();i++){
                orderedFood.add(i,orderScanner.dataScanned.get(i));
            }

            Collections.sort(orderedFood);
            System.out.println(orderedFood);
            int isOrderDiscounted = 0;
            double orderPrice = 0;
            for (int i = 0; i < orderedFood.size(); i++) {
                for (Map.Entry<Integer, MenuElement> entry : menuFoodMap.entrySet()) {
                    if (Objects.equals(orderedFood.get(i), entry.getKey())) {
                        System.out.println("proba nr" + i);
                        System.out.println(entry.getKey() + "klucz");
                        orderPrice += menuFoodMap.get(entry.getKey()).getMenuElementPrice();
                        System.out.println(orderPrice);
                    }
                }
            }

            double discount = 0.3;
            if(timeTookToMake > 30){
                orderPrice = orderPrice*discount;
                isOrderDiscounted = 1;
            }

            TxtIntFileWriter orderFileWriter = new TxtIntFileWriter();
            orderFileWriter.writeInt("readyOrdersToClient.txt",pickedOrder);
            orderFileWriter.writeInt("readyOrdersToClient.txt",isOrderDiscounted);

            oldTime = currentTime;
        }
    }
}
}
