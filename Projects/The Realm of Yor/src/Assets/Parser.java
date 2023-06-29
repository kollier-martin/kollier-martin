package Assets;

import Commands.Command;
import Commands.CommandList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * This parser reads user input and tries to interpret it as a
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 */

public class Parser {

    private final CommandList commandList;
    private String firstWord, secondWord;
    private String input = "";

    /**
     * Initializes the parser to parse said commands from the user
     */
    public Parser() {
        this(new CommandList());
    }

    /**
     * Constructor for Parser
     */
    public Parser(CommandList commands) {
        this.commandList = commands;
    }

    /**
     * Parses the user input for commands
     */
    public Command getInput() {
        System.out.print("> ");

        // Places user input into a string called 'input'
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // ERROR CHECK
        try {
            input = reader.readLine();
        } catch (IOException e) {
            System.out.println("I believe that is a foreign language, may you try that again");
        }

        // Parses the user's input
        StringTokenizer token = new StringTokenizer(input);

        /* Sets the firstWord variable to be the first word that the player inputs
         * then checks if there was a second word. The second word is then set
         * into the variable secondWord
         */

        firstWord = token.nextToken();
        if (token.hasMoreTokens()) {
            secondWord = token.nextToken();
        }

        // Returns the command after NULL checking
        Command command = commandList.getKey(firstWord);

        if (command == null) {
            System.out.println("This command either does not exist or you did not say a valid option");
        } else {
            command.setSecondWord(secondWord);
        }

        return command;
    }

    /**
     * Prints all usable commands
     */
    public void printAll() {
        commandList.printAll();
    }
}
