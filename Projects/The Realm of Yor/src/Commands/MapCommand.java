package Commands;

import Assets.Player;

public class MapCommand extends Command {
    public MapCommand() {
        super("Map");
    }

    @Override
    public boolean execute(Player player) {
        /* Print out exits for currentRoom */

        System.out.print("You can exit out in these directions: ");
        player.getRoom().printExits();
        System.out.println("");

        return false;
    }
}
