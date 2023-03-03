package Dominoes;

/**
 * Side of the domino
 *
 * @author Kollier Martin
 * @date 9/14/2018
 */
public class Side {
    private final int value;
    private Side inside;
    private Side outside;

    public Side() {
        this(0);
    }

    public Side(int value) {
        this.value = value;
    }

    //connects inside values
    public static void inner(Side side1, Side side2) {
        side1.inside = side2;
        side2.inside = side1;
    }

    //connects outside values
    public static void outer(Side side1, Side side2) {
        side1.outside = side2;
        side2.outside = side1;
    }

    public int getValue() {
        return value;
    }

    public Side getInside() {
        return inside;
    }

    public Side getOutside() {
        return outside;
    }

    @Override
    public String toString() {
        return this.getValue() + ":" + this.getInside().getValue();
    }

    public Side getSideForValue(int value) {
        if (outside == null) {
            if (this.value == value) {
                return this;
            } else {
                return null;
            }
        } else {
            return this.outside.inside.getSideForValue(value);
        }
    }

    public Side connect(Side side) {
        if (this.outside != null) {
            return this.outside.inside.connect(side);
        } else {
            if (this.getValue() == side.getValue()) {
                Side.outer(this.outside, side);
                return side.inside;
            } else {
                return null;
            }
        }
    }

    public boolean checkForValue(int value) {
        if (outside == null)  //end of played row
        {
            return this.value == value;
        } else {
            return this.outside.inside.checkForValue(value); //recursive method
        }
    }
}