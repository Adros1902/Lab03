package klientApp;

import commonElements.MenuElement;
import commonElements.MenuFileScanner;
import commonElements.TxtFileScanner;
import commonElements.TxtFileWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class KlientApp {

    public static void main(String[] args) throws IOException {
        System.out.println("mass");
        MenuFileScanner scanner = new MenuFileScanner("menu.txt");
        Scanner clientScanner = new Scanner(System.in);
        ArrayList<MenuElement> menuElements = new ArrayList<>(scanner.menuElementsData);
        int amountOfMenuElements = menuElements.size();
        int clientId = 0;
        ArrayList<Integer> currentClientsId = new ArrayList<>();
        TxtFileScanner txtFileScanner = new TxtFileScanner("clientsId.txt");
        if(txtFileScanner.fileIsEmpty){
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
            for(int i = 0;i < txtFileScanner.dataScanned.size();i++){
                currentClientsId.add(txtFileScanner.dataScanned.get(i)+1);
            }
            clientId = currentClientsId.size()+1;
            FileWriter textWriter = new FileWriter("clientsId.txt",true);
            textWriter.write(String.valueOf(clientId));
            textWriter.write(System.lineSeparator());
            textWriter.close();
        }
        System.out.println("Aby rozpoczac wpisz slowo 'start'");
        System.out.println("Witamy! Twoj indywidualny numer klienta to: "+clientId+"\n"+"Ponizej znajduje sie menu:");

        for(int i=0;i<menuElements.size();i++){
        System.out.println(menuElements.get(i).toStringKlient());
        }
        int clientInput = 0;
        ArrayList<Integer> clientOrder = new ArrayList<>();
        int orderTime=0;
        System.out.println("Wybierz co chcialbys zamowic (wpisz numer pozycji i kliknij enter), aby zakonczyc wybieranie wpisz '0' :");
        clientInput = clientScanner.nextInt();
        boolean temp = true;
        System.out.println("mass ped");
        if(clientInput != 0){
            clientOrder.add(0,orderTime);
            clientOrder.add(clientInput);
            while(temp == true) {
                System.out.println(clientInput + "input");
                clientInput = clientScanner.nextInt();
                if(clientInput == 0) {
                    temp = false;
                    System.out.println("Dziekujemy za zlozenie zamowienia. Gdy zamowienie bedzie gotowe, pojawi sie wiadomosc na ekranie");
                    break;
                }
                clientOrder.add(clientInput);
            }
        }else {
            System.out.println("Nic nie wybrales. Zapraszamy ponownie!");
        }
            System.out.println(clientOrder);
    }
}

