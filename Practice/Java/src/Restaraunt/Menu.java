package Restaraunt;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static Restaraunt.Menu.Type.ADULT;
import static Restaraunt.Menu.Type.KIDS;

@Getter
public class Menu {
    Map<Item, Item.Category> menuItems;

    public Menu(Type type) {
        if (type.equals(ADULT)) {
            menuItems = new HashMap<>();
            menuItems.put(new Item("Some description here", "Shrimp Scampi", 14.99), Item.Category.ENTREES);
            menuItems.put(new Item("Some description here", "Chicken Parmesan", 12.99), Item.Category.ENTREES);
        } else if (type.equals(KIDS)) {
            menuItems = new HashMap<>();
            menuItems.put(new Item("Some description here", "Chicken Fingers", 6.99), Item.Category.ENTREES);
            menuItems.put(new Item("Some description here", "Corn Dog", 5.99), Item.Category.ENTREES);
        }
    }

    public enum Type {
        KIDS,
        ADULT
    }
}
