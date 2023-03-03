package Commands;

import Assets.Player;

import java.util.Scanner;

public class ExitCommand extends Command {
    private Scanner scn = new Scanner(System.in);

    public ExitCommand() {
        super("Exit");
    }

    /**
     * Exits the game completely
     */
    @Override
    public boolean execute(Player player) {
        System.out.println("");
        System.out.println("Are you sure you want to exit the game? Your progress will not be saved.");
        System.out.print("> ");
        String answer = scn.nextLine();
        System.out.println("");

        if (answer.equalsIgnoreCase("Yes")) {
            System.out.println("You have one more chance to cancel this process. ARE YOU SURE?");
            System.out.print("> ");
            answer = scn.nextLine();
            if (answer.equalsIgnoreCase("Yes")) {
                System.out.println("Alright then! Goodbye!");
                System.exit(0);
            } else if (answer.equalsIgnoreCase("No")) {
                System.out.print("Smart choice! Continue\n\n");
            }
        } else if (answer.equalsIgnoreCase("No")) {
            System.out.print("Smart choice! Continue\n\n");
        }

        return false;
    }

}
