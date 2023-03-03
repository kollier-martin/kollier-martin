package Dominoes;

/**
 * Domino object
 *
 * @author Kollier Martin
 * @date 9/14/2018
 */
public class Domino {
    private final Side side1;
    private final Side side2;

    public Domino(Side side1, Side side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    public boolean isDouble() {
        return side1.getValue() == side2.getValue(); // returns true if a == b, returns false if a != b
    }

    public boolean checkForValue(int value) {
        return side1.checkForValue(value) || side2.checkForValue(value);
    }

    public Side getSideForValue(int value) {
        Side side = side1.getSideForValue(value);

        if (side == null) {
            side = side2.getSideForValue(value);
        }

        return side;
    }

    @Override
    public String toString() {
        return side1.toString();
    }
}

