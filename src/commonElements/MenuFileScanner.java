package commonElements;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MenuFileScanner {
    public ArrayList<MenuElement> menuElementsData = new ArrayList<>();
    public MenuFileScanner(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNext()) {
            int menuElementId = scanner.nextInt();
            String menuElementName = scanner.next();
            int menuElementPrice = scanner.nextInt();
            int menuElementTime = scanner.nextInt();
            MenuElement menuElement = new MenuElement(menuElementId, menuElementName, menuElementPrice, menuElementTime);
            menuElementsData.add(menuElement);
        }

    }}

