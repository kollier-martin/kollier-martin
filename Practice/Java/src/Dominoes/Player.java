package Dominoes;

import java.util.ArrayList;

/**
 * Defines the player as an entity
 *
 * @author Kollier Martin
 * @date 9/14/2018
 */
public class Player {
    private final ArrayList<Domino> hand;
    private String name;

    /**
     * Constructor for objects of class Player
     */
    public Player() {
        hand = new ArrayList<>();
    }

    /**
     * Constructor for objects of class Player w/ name
     */
    public Player(String name) {
        hand = new ArrayList<>();
        this.name = name;
    }

    /**
     * Returns the player's name
     */
    public String getPName() {
        return name;
    }

    /**
     * Adds domino to the player hands
     */
    public void receive(Player player, Domino domino) {
        if (player.numDomInHand() == 7) {
            System.out.println(player.getPName() + "has a full hand already");
        } else {
            this.hand.add(domino);
        }
    }

    public void remove(int specified) //specified is the specific domino in the hand
    {
        Domino domino = hand.get(specified); //receives the domino at the specified index
        hand.remove(domino); //removes specified domino
    }

    public boolean canPlay(Side side, int value) {
        boolean result = false;
        for (Domino domInHand : hand) {
            Side side1 = side.getInside().getSideForValue(value);
            Side side2 = side.getOutside().getSideForValue(value);
            result = domInHand.checkForValue(value) == side1.checkForValue(value) || domInHand.checkForValue(value) == side2.checkForValue(value);
        }

        return result;
    }

    public boolean containsInHand(Domino domino) {
        return hand.contains(domino);
    }

    /**
     * Returns the contents of the player's hand
     */
    public ArrayList<Domino> getHand() {
        return this.hand; //use this keyword so it doesn't call the empty arraylist defined above
    }

    /**
     * Displays the number of dominoes in the player's hand
     */
    public int numDomInHand() {
        return hand.size();
    }

    /**
     * Returns false if hand is not empty, returns true if hand is empty
     */
    public boolean isEmpty() {
        return hand.isEmpty();
    }
}