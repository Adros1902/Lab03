package klientApp;

import commonElements.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class KlientApp {

    public static void main(String[] args) throws IOException {
        ClockTime clock = new ClockTime();
        //clock.clock();
        System.out.println("mass");
        new CreateNewFile("ordersToMake.txt");
        MenuFileScanner menuFileScanner = new MenuFileScanner("menu.txt");
        Scanner clientScanner = new Scanner(System.in);
        ArrayList<MenuElement> menuElements = new ArrayList<>(menuFileScanner.menuElementsData);

        System.out.println("Aby rozpoczac wpisz slowo 'start'");
        String userInput = clientScanner.next();
        boolean start = false;
        if(Objects.equals(userInput,"start")){
            start = true;
        }
        int currentTime = 0;

        System.out.println("Aktualny czas:"+currentTime);

        if(start){
            while(start){
        int clientId = 0;
        clock.refresh();
        System.out.println("Aby dodac minute nalezy wpisac: 'minuta' ");
        String userInputTime = clientScanner.next();
        if(Objects.equals(userInputTime,"minuta")){
            clock.addTime();
        }
        ArrayList<Integer> currentClientsId = new ArrayList<>();
        TxtFileScanner txtIntFileScanner = new TxtFileScanner();
        txtIntFileScanner.txtIntFileScanner("clientsId.txt");
        if(txtIntFileScanner.fileIsEmpty){
            int i = 1;
            try{
            FileWriter textWriter = new FileWriter("clientsId.txt");
            textWriter.write(String.valueOf(i));
            textWriter.write(System.lineSeparator());
            textWriter.close();
            } catch (IOException e){
                System.out.println("error");
                e.printStackTrace();
            }
            clientId=i;
        }else{
            System.out.println("enis123");
            for(int i = 0; i < txtIntFileScanner.dataScanned.size(); i++){
                currentClientsId.add(txtIntFileScanner.dataScanned.get(i)+1);
            }
            clientId = currentClientsId.size()+1;
            FileWriter textWriter = new FileWriter("clientsId.txt",true);
            textWriter.write(String.valueOf(clientId));
            textWriter.write(System.lineSeparator());
            textWriter.close();
            System.out.println("test1");
        }

        System.out.println("Witamy! Twoj indywidualny numer klienta to: "+clientId+"\n"+"Ponizej znajduje sie menu:");

        for(int i=0;i<menuElements.size();i++){
        System.out.println(menuElements.get(i).toStringKlient());
        }

        int clientInput;
        ArrayList<Integer> clientOrder = new ArrayList<>();

        System.out.println("Wybierz co chcialbys zamowic (wpisz numer pozycji i kliknij enter), aby zakonczyc wybieranie wpisz '0' :");
        clientInput = clientScanner.nextInt();
        boolean temp = true;
        System.out.println("mass ped");

        if(clientInput != 0){
            clientOrder.add(0,currentTime);
            clientOrder.add(clientInput);
            while(temp == true) {
                System.out.println(clientInput + "input");
                clientInput = clientScanner.nextInt();

                if(clientInput == 0) {
                    temp = false;
                    TxtIntFileWriter txtIntFileWriter = new TxtIntFileWriter();
                    txtIntFileWriter.writeInt("ordersToMake.txt",clientId);
                    System.out.println("Dziekujemy za zlozenie zamowienia. Gdy zamowienie bedzie gotowe, pojawi sie wiadomosc na ekranie");
                    start = false;
                    break;
                }
                clientOrder.add(clientInput);
            }
            String clientOrderFileName = clientId+"_order.txt";
            System.out.println(clientOrderFileName);

            for(int i=0;i<clientOrder.size();i++){
                TxtIntFileWriter txtIntFileWriter = new TxtIntFileWriter();
                txtIntFileWriter.writeInt(clientOrderFileName,clientOrder.get(i));
            }

        }else {
            System.out.println("Nic nie wybrales. Zapraszamy ponownie!");
            start = false;
        }
            System.out.println(clientOrder);
    }
            System.out.println("Aby rozpoczac wpisz slowo 'start'");
            userInput = clientScanner.next();
            if(Objects.equals(userInput,"start")){
                start = true;
            }

            UserInputScanner userInputScanner = new UserInputScanner();
            String userInput2 = userInputScanner.inputStringScanner();
            if(Objects.equals(userInput2,"refresh")){
                currentTime = clock.refresh();
            } else if (Objects.equals(userInput2,"add")) {
                clock.addTime();
                currentTime = clock.refresh();
            }

        } else {
            System.out.println("Nieprawidlowa komenda");
        }
}
}


