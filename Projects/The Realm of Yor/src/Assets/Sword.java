package Assets;

/**
 * This class represents the weapons of choice in the game.
 *
 * @author Kollier Martin
 * @version 10/27/2018
 */

public class Sword extends Item {
    private int dmg;

    /**
     * Sword No Argument Constructor
     */
    public Sword() {
        this("", 0, 0);
    }

    /**
     * Sword Constructor
     */
    public Sword(String name, int quantity, int dmg) {
        super(name, quantity);
        this.dmg = dmg;
    }

    /**
     * Returns dmg value of weapon
     */
    public int getDmg() {
        return dmg;
    }
}
