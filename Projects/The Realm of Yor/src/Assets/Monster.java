package Assets;

import java.util.Random;

/**
 * This class represents monsters in the game. Each monster will have
 * a random spawn chance.
 *
 * @author Kollier Martin
 * @version 11/2/2018
 */


public class Monster {
    /*
     * I want to have a HashMap full of monster types and their names
     * to be randomly generated when the monster is created
     */

    //private HashMap<String, Monster> monsterList;
    private double health;
    private String name;
    private int baseDMG, maxDMG;
    private Random rand = new Random();

    /**
     * Monster constructor
     */
    public Monster(String name, int health, int baseDMG, int maxDMG) {
        this.health = health;
        this.name = name;
        this.baseDMG = baseDMG;
        this.maxDMG = maxDMG;
    }

    /**
     * Defends against an attack. Halves damage taken
     */
    public double defend(double dmgTaken) {
        System.out.println(name + " defends against your attack.");
        return dmgTaken * 0.5;
    }

    /**
     * Calculates and attacks player depending on the players action
     */
    public double attack(Player player) {
        int hitChance = rand.nextInt(8 - 0) + 0;
        int critChance = rand.nextInt(15 - 0) + 0;
        int output = rand.nextInt(maxDMG - baseDMG) + baseDMG;
        int dmgDone = 0;

        if (hitChance == 2) {
            System.out.println(this.name + " swings and misses. Better luck next time");
            System.out.print("\n");
        } else {
            if (critChance != 2) {
                if (Battle.input.equalsIgnoreCase("defend")) {
                    int defend = (int) player.defend(output);
                    System.out.println(this.name + " hits you for " + defend);
                    player.setHealth(player.getHealth() - defend);
                    System.out.println(player.getName() + " is now at " + (int) player.getHealth() + " health");
                    System.out.print("\n");
                } else {
                    System.out.println(this.name + " hits you for " + output);
                    player.setHealth(player.getHealth() - output);
                    System.out.println(player.getName() + " is now at " + (int) player.getHealth() + " health");
                    System.out.print("\n");
                }
            } else if (critChance == 2) {
                dmgDone = (int) (output * 1.5);
                player.setHealth(player.getHealth() - dmgDone);
                System.out.println(this.name + " hits you with the force of 6 warriors and almost sends"
                        + " you home crying. Critical hit for " + dmgDone + "!");

                System.out.println(player.getName() + " is now at " + (int) player.getHealth() + " health");
                System.out.print("\n");
            }
        }
        return (int) player.getHealth();
    }

    /**
     * Checks if Monster is dead
     */
    public boolean isDead() {
        boolean dead = false;

        if (this.health <= 0) {
            dead = true;
        }

        return dead;
    }

    /**
     * Checks if Monster is alive
     */
    public boolean isAlive() {
        boolean alive = false;

        if (this.health > 0) {
            alive = true;
        }

        return alive;
    }

    /**
     * Checks if Monster is dead
     */
    public double getHealth() {
        return health;
    }

    /**
     * Sets Monster health to a specified attribute
     */
    public void setHealth(double result) {
        this.health = result;
    }

    /**
     * Returns the Monster's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets Monster name to a specified attribute
     */
    public void setName(String name) {
        this.name = name;
    }
}
