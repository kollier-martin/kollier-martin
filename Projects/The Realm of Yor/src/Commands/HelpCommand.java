package Commands;

import Assets.Player;

/*
 * When the player says help, this class prints out the dialog to let them see the list of
 * commands that are currently usable.
 */

public class HelpCommand extends Command {
    private CommandList commands;

    public HelpCommand(CommandList usableWords) {
        super("Help");
        commands = usableWords;
    }

    @Override
    public boolean execute(Player player) {
        /*
         * Prints out list of usable commands
         */

        System.out.println("I am still here lost one. Allow me to help! ");
        System.out.print("You may call upon these words of power at any time: ");
        commands.printAll();
        System.out.println("");

        return false; //placeholder
    }
}