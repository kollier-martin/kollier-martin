package Assets;

import java.util.Random;

/**
 * This class represents the usable items in the game.
 *
 * @author Kollier Martin
 * @version 10/27/2018
 */

public class Item {
    private String name;
    private int id;
    private int quantity;
    private Random rand = new Random();

    public Item() {
        this(" ", 0);
    }

    public Item(String name, int quantity) {
        this.name = name;
        this.id = rand.nextInt(50); //create a form of duplicity checking
        this.quantity = quantity;
    }

    public void increment() {
        quantity++;
    }

    public void decrement() {
        quantity--;
    }

    public int getID() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int num) {
        this.quantity = num;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String string = this.name + " "; // + this.id;
        return string;
    }
}
