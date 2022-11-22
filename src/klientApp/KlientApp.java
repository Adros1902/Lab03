package klientApp;

import commonElements.MenuElement;
import commonElements.TxtFileScanner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class KlientApp {

    public static void main(String[] args) throws IOException {
        System.out.println("mass");
        TxtFileScanner scanner = new TxtFileScanner("menu.txt");
        Scanner clientScanner = new Scanner(System.in);
        ArrayList<MenuElement> menuElements = new ArrayList<>(scanner.menuElementsData);
        int amountOfMenuElements = menuElements.size();
        int clientId=1;
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
                    break;}
                clientOrder.add(clientInput);
            }
        }
            System.out.println(clientOrder);


    }
}

