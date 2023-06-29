package Commands;

import Assets.Player;

/**
 * This class is the basis for setting up the commands that will be used in the game
 * A variable, secondWord, indicates that there is a second word to be applied for a command
 */

public abstract class Command {
    private String secondWord;
    private String name;

    /**
     * Basic constructor the creation of the Commands
     */
    public Command(String name) {
        secondWord = null;
        this.name = name;
    }

    /**
     * Return the second word of this command. If no
     * second word was entered, the result is null.
     */
    public String getSecondWord() {
        return secondWord;
    }

    /**
     * Define the second word of this command
     */
    public void setSecondWord(String secondWord) {
        this.secondWord = secondWord;
    }

    /**
     * Check whether a second word was entered for this
     * command.
     */
    public boolean hasSecondWord() {
        return secondWord != null;
    }

    /**
     * Returns the name of the command.
     */
    public String getName() {
        return name;
    }

    /**
     * Executes the command
     */
    public abstract boolean execute(Player player);
}
