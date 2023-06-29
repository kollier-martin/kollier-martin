package Assets;

import java.util.Random;
import java.util.Scanner;

public class Battle {
    public static String input;
    /**
     * Random chance to hit and miss
     * Attacks said creature subtracting
     */

    private Scanner scn = new Scanner(System.in);
    private int monsterMove;
    private Random rand = new Random();
    private double result, monResult;

    /**
     * Empty constructor for execution of battle method
     */
    public Battle(Player player, Monster monster) {

    }

    /**
     * Battle scene. Loops between said monster and the current player
     */
    public boolean battle(Player player, Monster monster) {
        boolean win = false;

        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            System.out.println("Do you want to Attack, Defend, or Use an item?");
            System.out.print("> ");
            input = scn.nextLine();

            monsterMove = rand.nextInt(2 - 1) + 1;

            if (input.equalsIgnoreCase("Attack")) {
                System.out.print("\n");
                result = player.attack(monster);

                if (monsterMove == 1) {
                    monResult = monster.attack(player);
                    player.setHealth(monResult);
                } else if (monsterMove == 2) {
                    monResult = monster.defend(result);
                }

                monster.setHealth(result);
            } else if (input.equalsIgnoreCase("Defend")) {
                System.out.print("\n");
                if (monsterMove == 1) {
                    monResult = monster.attack(player);
                }
            } else if (input.equalsIgnoreCase("Use")) {
                System.out.print("Which item do you want to use from your bag: " + player.printBag());
                System.out.print("> ");
                String item = scn.nextLine();

                System.out.print("\n");

                player.useItem(item);

                if (monsterMove == 1) {
                    monResult = monster.attack(player);
                    player.setHealth(monResult);
                }
            }

            if (player.isDead() == true) {
                System.out.println("You have been defeated...");
                win = false;
            } else if (monster.isDead() == true) {
                System.out.println(monster.getName() + " has been defeated.");
                win = true;
            }
        }

        return win;
    }
}
