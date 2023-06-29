package Assets;

import java.util.HashSet;


/**
 * This class represents the player's inventory.
 *
 * @author Kollier Martin
 * @version 10/25/2018
 */


public class Inventory {
    private HashSet<Item> items;

    /**
     * Constructor to initiate creation of the Inventory
     */
    public Inventory() {
        items = new HashSet<Item>();
    }

    /**
     * Player starts with 2 potions and a sword
     */
    public void defaultBag() {
        items.add(new Item("Potion", 2));
        items.add(new Sword("BroadSword", 1, 12));
    }

    /**
     * Returns a clone of the inventory that can not be modified, just viewed
     */
    public Object getInv() {
        return items.clone();
    }

    /**
     * If item is in item array, remove the item and use it for its purpose
     */
    public boolean checkForItem(String itemCheck) {
        boolean status = false;
        for (Item item : this.items) {
            if (item.getName() == itemCheck) {
                status = true;
            }
        }
        return status;
    }

    /**
     * Checks HashSet for item
     */
    public boolean contains(Item item) {
        return items.contains(item);
    }

    /**
     * Decreases quantity by one after use and if the quantity is at 0, remove the item from the HashSet
     */
    public void useItem(Item item) {
        int itemQuan = item.getQuantity() - 1;
        item.setQuantity(itemQuan);

        if (item.getQuantity() == 0) {
            item.decrement();
        }
    }

    /**
     * Adds item to the items HashSet
     */
    public void add(Item item) {
        items.add(item);
    }

    /**
     * Removes item from the items HashSet
     */
    public void remove(Item item) {
        if (items.size() > 0) {
            items.remove(item);
        }
    }

    /**
     * Returns false if items is empty, else true
     */
    public boolean isEmpty() {
        boolean value = false;
        if (items.isEmpty()) {
            value = true;
        }

        return value;
    }

    /**
     * Print out contents of items
     */
    @Override
    public String toString() {
        String string = "Your inventory contains: ";
        for (Item item : this.items) {
            string += item.toString() + "x" + item.getQuantity() + ", ";
        }

        return string;
    }
}
