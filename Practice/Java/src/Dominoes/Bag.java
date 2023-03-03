package Dominoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Creates a container, bag, to hold the domino pack
 *
 * @author Kollier Martin
 * @date 9/14/2018
 */
public class Bag {
    private ArrayList<Domino> contents;
    // private int packSize = %i; - uncomment and modify code for a custom packSize
    private Random rand = new Random();

    /**
     * Constructor for objects of class Bag
     */
    public Bag() {
        contents = new ArrayList<Domino>();

        // Creates 28 dominoes using a Nested for Loop
        for (int i = 0; i <= 14; i++) // iterates the loop 14 times, adding 1 to 0.. 14 times
        {
            for (int n = 0; n <= 14; n++) {
                Side side1 = new Side(i);
                Side side2 = new Side(n);
                Domino domino = new Domino(side1, side2);
                contents.add(domino);
            }
        }
    }

    /**
     * Return random domino from bag
     */
    public Domino getRandom() {
        int randPiece = rand.nextInt(28 - 1 + 1) + 1;
        return contents.get(randPiece);
    }

    /**
     * Return list of dominoes from bag
     */
    public ArrayList<Domino> getDominoes() {
        return contents;
    }

    /**
     * Shuffles bag
     */
    public void shuffleBag() {
        Collections.shuffle(contents);
    }

    /**
     * Displays pieces left in the bag
     */
    public int piecesLeft() {
        return contents.size();
    }

    @Override
    public String toString() {
        return "Num of dominoes left: " + piecesLeft();
    }
}
