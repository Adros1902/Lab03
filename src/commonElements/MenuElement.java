package commonElements;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuElement {
    int menuElementId;
    String menuElementName;
    int menuElementPrice;
    int timeToMake;

    public String toStringKlient() {
        return "" + menuElementId +". " + menuElementName+ " " + menuElementPrice +" pln";
    }

    public int getMenuElementId() {
        return menuElementId;
    }

    public String getMenuElementName() {
        return menuElementName;
    }

    public int getMenuElementPrice() {
        return menuElementPrice;
    }

    public int getTimeToMake() {
        return timeToMake;
    }


    public MenuElement(int menuElementId, String menuElementName, int menuElementPrice, int timeToMake){
        this.menuElementId = menuElementId;
        this.menuElementName = menuElementName;
        this.menuElementPrice = menuElementPrice;
        this.timeToMake = timeToMake;
    }
}
