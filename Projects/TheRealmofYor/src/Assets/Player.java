package Assets;
/**
 * This class represents players in the game. Each player has
 * a current location.
 *
 * @author Kollier Martin
 * @version 10/25/2018
 */

//import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;

public class Player {
    private Room currentRoom;
    private String name;
    private Inventory bag;
    private double health;
    private int baseDMG, maxDMG;

    private Random rand = new Random();
    private Scanner scn = new Scanner(System.in);

    /**
     * No Argument Constructor for Player
     */
    public Player() {
        this(null);
    }

    /**
     * Constructor for Player Object
     */
    public Player(Room currentRoom) {
        bag = new Inventory();
        bag.defaultBag();

        System.out.print("Please enter the name of your character > ");
        this.name = scn.next();
        System.out.print("\n");

        this.currentRoom = currentRoom;
        this.health = 150;
        this.baseDMG = 15;
        this.maxDMG = 25;
    }

    /**
     * Returns Player Name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets Player Name As Argument Value
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Moves the player from currentRoom to argument location
     */
    public void moveRoom(String room) {
        Room next = currentRoom.getExit(room);

        //See if room can be exited
        //If so, set player to said room
        if (next == null) {
            System.out.println("You walk right into a wall. There is no exit here!");
            System.out.println("");
        } else {
            setRoom(next);
            System.out.println("You have entered the " + next.getDesc());
            System.out.println("");
        }

    }

    //Iterates through bag for item that is called for, removes that item and the item does its purpose
    public void useItem(String item) {
        if (bag.isEmpty()) {
            System.out.println("Your bag is empty, there are no items to use.");
        } else if (item.equalsIgnoreCase("Potion") == true /*&& bag.checkForItem(item) == true*/) {
            if (health == 100) {
                System.out.println("Your health is already full. This action can not be done.");
            } else {
                health = this.health + 15;
                System.out.println("You drink the " + item + ". Health has been increased by 15. Current health: " + this.health);
            }
        } else if (!item.equalsIgnoreCase("Potion")) {
            System.out.println("You can not use this item on yourself");
        }
    }

    /**
     * Adds item to Player's bag
     */
    public void addToBag(Item item) {
        bag.add(item);
    }

    /**
     * Halves damage taken
     */
    public double defend(double dmgTaken) {
        System.out.println("You widen your stance and brace for an attack.");
        System.out.print("\n");
        return dmgTaken * 0.5;
    }

    /**
     * Calcualtes and attacks specified Monster object
     */
    public double attack(Monster monster) {
        int hitChance = rand.nextInt(11 - 0) + 0;
        int critChance = rand.nextInt(21 - 0) + 0;
        int output = rand.nextInt(maxDMG - baseDMG) + baseDMG;
        int dmgDone = 0;

        if (hitChance == 2) {
            System.out.println("You missed your attack! Aim for the knees!");
            System.out.print("\n");
        } else {
            if (critChance != 2) {
                if (bag.checkForItem("Broadsword") == true) {
                    System.out.println("You hit " + monster.getName() + " for " + (output + 12));
                    monster.setHealth(monster.getHealth() - output);
                    System.out.println(monster.getName() + " is now at " + (int) monster.getHealth() + " health");
                    System.out.print("\n");
                } else {
                    System.out.println("You hit " + monster.getName() + " for " + output);
                    monster.setHealth(monster.getHealth() - output);
                    System.out.println(monster.getName() + " is now at " + (int) monster.getHealth() + " health");
                    System.out.print("\n");
                }
            } else if (critChance == 2) {
                dmgDone = (int) (output * 1.5);
                System.out.println("You swing visciously at " + monster.getName()
                        + " and you almost knock it's boots off. Critical hit " + dmgDone + "!");

                monster.setHealth(monster.getHealth() - dmgDone);
                System.out.println(monster.getName() + " is now at " + (int) monster.getHealth() + " health");
                System.out.print("\n");
            }
        }

        return monster.getHealth();
    }

    /**
     * Return Player's current location
     */
    public Room getRoom() {
        return currentRoom;
    }

    /**
     * Sets currentRoom to specified room
     */
    public void setRoom(Room room) {
        currentRoom = room;
    }

    /**
     * Return Player's current bag
     */
    public Inventory getBag() {
        return bag;
    }

    /**
     * Prints out Player's current bag
     */
    public String printBag() {
        return bag.toString() + "\n";
    }

    /**
     * Returns the Player's health
     */
    public double getHealth() {
        return health;
    }

    /**
     * Sets current health value to specified value
     */
    public void setHealth(double health) {
        this.health = health;
    }

    /**
     * Checks to see if Player is dead
     */
    public boolean isDead() {
        boolean dead = false;

        if (this.health <= 0) {
            dead = true;
        }

        return dead;
    }

    /**
     * Checks to see if Player is alive
     */
    public boolean isAlive() {
        boolean alive = false;

        if (this.health > 0) {
            alive = true;
        }

        return alive;
    }

    /**
     * Prints out the Player's name
     */
    @Override
    public String toString() {
        return this.name;
    }
}
