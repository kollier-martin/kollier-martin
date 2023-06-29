package Commands;

import Assets.Player;

public class BagCommand extends Command {
    public BagCommand() {
        super("Bag");
    }

    /**
     * Returns contents of the player's bag
     */
    @Override
    public boolean execute(Player player) {
        System.out.println(player.printBag());
        return false;
    }
}
