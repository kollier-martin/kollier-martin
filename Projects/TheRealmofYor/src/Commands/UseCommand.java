package Commands;

import Assets.Player;

public class UseCommand extends Command {
    public UseCommand() {
        super("Use");
    }

    @Override
    public boolean execute(Player player) {
        /* Register the secondWord to hold the destination
         * Player uses said item
         * if Player does not input an item to use then the player does not use anything
         */

        if (hasSecondWord()) {
            String secondWord = getSecondWord();
            player.useItem(secondWord);
        } else {
            System.out.println("I don't understand, what item should I use?");
            System.out.println("");
        }

        return false;
    }
}