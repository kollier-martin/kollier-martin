package Assets;
/**
 * This class represents the rooms in the game. A room can contain a game winning item
 *
 * @author Kollier Martin
 * @version 10/25/2018
 */

import java.util.HashMap;
//import java.util.Random;

public class Room {
    private String description; //size
    private HashMap<String, Room> exits;
    private Artifact artifact;

    /**
     * Basic constructor for room class
     */
    public Room(String description, Artifact artifact) {
        //this.size = setSize();
        this.description = description;
        exits = new HashMap<String, Room>();
        this.artifact = artifact;
    }
	
	/* FOR FUTURE IMPLEMENTATION
	public String getSize()
	{
		return size;
	}
	*/

    /**
     * Returns the description of the room
     */
    public String getDesc() {
        return description;
    }
	
	/* FOR FUTURE IMPLEMENTATION
	public String setSize()
	{
		String[] roomSizes = new String[]{"Small", "Medium", "Large"};
		String size = roomSizes[new Random().nextInt(roomSizes.length)];
		return size;
	}
	*/

    /**
     * Set direction and what room to exit to
     */
    public void setExit(String exit, Room next) {
        exits.put(exit, next);
    }

    /**
     * Returns the room of said direction
     */
    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public Artifact getArti() {
        return this.artifact;
    }

    /**
     * Contains the artifacts name
     */
    public String artiName() {
        return artifact.getName();
    }

    /**
     * Prints out the artifacts description
     */
    public String artiDesc() {
        return artifact.getDesc();
    }

    /**
     * Checks if room has an artifact
     */
    public boolean hasArti() {
        boolean value;

        if (artifact != null) {
            value = true;
        } else {
            value = false;
        }

        return value;
    }

    /**
     * Prints all available exits for said room
     */
    public void printExits() {
        for (String exit : exits.keySet()) {
            System.out.print(exit + "  ");
        }
        System.out.println();
    }

    /**
     * Remove artifact from room
     */
    public void artiRem() {
        this.artifact = null;
    }
}
