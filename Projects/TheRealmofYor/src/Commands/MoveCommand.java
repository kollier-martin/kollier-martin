package Commands;

import Assets.Player;

public class MoveCommand extends Command {
    public MoveCommand() {
        super("Move");
    }

    @Override
    public boolean execute(Player player) {
        /* Register the secondWord to hold the destination
         * Move the Player to said destination
         * if Player does not input a destination then.. the player does not move
         */

        if (hasSecondWord()) {
            String secondWord = getSecondWord();
            player.moveRoom(secondWord);
        } else {
            System.out.println("I don't understand, walk where?");
            System.out.println("");
        }

        return false;
    }
}
