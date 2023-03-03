package Dominoes;

/**
 * Main method for execution of the Domino game
 *
 * @author Kollier Martin
 * @date 9/14/2018
 */
public class Table {
    private final Bag gameBag;
    private Domino starter = null;

    public Table() {
        gameBag = new Bag();
    }

    public static void main(String[] args) {
        Table gameTable = new Table();

        Player player1 = new Player("Joe");
        Player player2 = new Player("Paul");
        Player player3 = new Player("Jackson");
        Player player4 = new Player("Biscuit");

        gameTable.dealHand(player1);
        gameTable.dealHand(player2);
        gameTable.dealHand(player3);
        gameTable.dealHand(player4);

        System.out.println(player1.numDomInHand()); // proof that player has 7 dominoes in hand :D
    }

    public void dealHand(Player player) {
        for (int i = 0; i < 7; i++) {
            player.receive(player, gameBag.getRandom());
        }
    }


    public boolean playPiece(Domino domino, Side side) {
        boolean result = false;
        if (starter == null) {
            if (domino.isDouble()) {
                starter = domino;
                result = true;
            }
        } else {
            Side endSide = (starter.getSideForValue(side.getValue()));

            if (endSide != null) {
                Side.outer(endSide, side);
                result = true;
            }
        }

        return result;
    }
}
