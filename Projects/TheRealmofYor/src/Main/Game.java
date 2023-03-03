package Main;

import Assets.*;
import Commands.Command;
import Commands.CommandList;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class is the instance of the game
 * a current location.
 *
 * @author Kollier Martin
 * @version 10/25/2018
 */

public class Game {
    private static final CommandList listOf = new CommandList();
    private static final LinkedList<Artifact> artifacts = new LinkedList<>();
    private static final Random rand = new Random();
    private static final Scanner scn = new Scanner(System.in);
    public static Player player = null;
    public static Parser parser;
    private static Game instance = null;

    /**
     * Constructor for Game class
     * Generates world and the player
     **/
    public Game() {
        parser = new Parser();
        player = new Player(createWorld());
    }

    /**
     * Generates artifacts
     */
    public static void createArtifacts() {
        artifacts.add(new Artifact(rand.nextInt(50), "Gair's Horn", ", The horn of the formidable foe Gair."
                + "\nDo you remember? When Gair was cast down from the Council, you fought him alone and"
                + " removed his horn."));

        artifacts.add(new Artifact(rand.nextInt(50), "Y�r's Garmet", ", Y�r's bath robe but what is this?"
                + "\nThis thing is impenatable by regular weapons!"
                + " Neat!"));

        artifacts.add(new Artifact(rand.nextInt(50), "Ilgan Compendium", ", A book full of powerful magic and"
                + " incantations.\nCould this really be the legendary Ilgan's creation.\nI remember when he was in the process"
                + " of creating this masterpiece."));

        artifacts.add(new Artifact(rand.nextInt(50), "Obsidian-Lined Necklace", ", An undeniable presence"
                + " resonates from within this crystal.\nY�r: This necklace... it can't be. Why is this here?\nThis is the lost artifact of"
                + " Humnen, the legendary warrior and my since then... deceased brother."));

        artifacts.add(new Artifact(rand.nextInt(50), "Arifcand Timber", ", A wooden shield? Wait, no. I remember this artifact. My "
                + "old shield, more sturdy than"
                + " magically reinforced walls. This should be useful"));

    }

    /**
     * Creates game instance containing all information
     */
    public static Game createInstance() {
        instance = new Game();
        return instance;
    }

    /**
     * Returns current instance
     */
    public static Game getInstance() {
        if (instance == null) {
            instance = createInstance();
        }

        return instance;
    }

    /**
     * Prints welcome message to the game
     */
    public static void WelcomeMessage() {
        //Create an ASCII art
        System.out.print("Welcome to 'The Realm of Y�r' this is a demo. The full game will be completed without an ETA."
                + " All suggestions are welcome .\n");
        System.out.print("Here is the list of commands: ");
        listOf.printAll();
        System.out.println("All commands are CASE SENSITIVE.");
        System.out.print("\n\t\t\t\t\t\tHave fun!!\n\n");

        String name = Game.player.toString();
        System.out.println("Welcome " + name + "... "
                + "You may wonder where you are right now, but there is no time to explain.\n"
                + "The world around you has fell to ruin and your past is the key to defeating the evil that is to blame for this.\n"
                + "You must venture into the world and look for specific items that will help you along your journey. With every item, you will learn a bit of your past.\n"
                + "First, you must escape this dungeon. There are 5 artifacts hidden in this dungeon. When you find all 5"
                + ", the hidden exit will open and you may see for yourself what the world has become.\n"
                + "Your commands are: 'Help  Move  Use  Search  Bag  Map  Exit'.\n"
                + "Here take these two potions for the road and if you ever need my help, just say 'Help' and I will appear.\n");
    }

    /**
     * Play Class that loops until win conditions are met
     */

    public static boolean play() {
        boolean complete = false;

        while (!complete) {
            Command command = parser.getInput();
            if (command == null) {
                System.out.println();
            } else {
                complete = command.execute(player);
            }
        }

        return complete;
    }

    /**
     * Main method that runs the game
     */
    public static void main(String[] args) {
        Game.createInstance();
        WelcomeMessage();
        while (play()) {
            if (play()) {
                System.out.println();
                System.out.println("Hello " + Game.player.getName() + ". You've made it!! Gair is behind this door down the"
                        + " Forbidden Path. You can exit the dungeon and battle Gair himself. "
                        + "Are you ready for this task champion? (Y/N or Yes/No)");

                while (true) {
                    System.out.print("> ");
                    String answer = scn.nextLine();

                    if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                        System.out.println();
                        System.out.print("The time has come...\n"
                                + "You exit the dungeon and you walk towards Gair's vicious roaring\n");
                        Gair gair = new Gair();

                        Battle sequence = new Battle(Game.player, gair);
                        if (sequence.battle(Game.player, gair)) {
                            System.out.println(gair.getName() + ": WHAT?! HOW CAN THIS BE. I MADE IT THIS FAR, I REFUSE "
                                    + "TO ACCEPT DEFEAT. I WILL TAKE THIS YOU AND THIS WHOLE REALM WITH ME. ISRONUMU-");
                            System.out.println("Y�r: NO! Gair don't do it");
                            System.out.println(gair.getName() + ": LINTK RUI UNTATUM\n");
                            System.out.println("With a flash of light and a sharp painful feeling... everything "
                                    + "descends into darkness.");
                            System.exit(0);
                        } else {
                            System.out.println(gair.getName() + ": *LAUGHING* Y�r! This is your champion? You two are pitiful.\nGair grabs you"
                                    + " off of the ground and walks over to Y�r, stunned, he watches as Gair dissolves you with"
                                    + " fel magic.\nLimb by limb you dissipate but in your last moments of agony, Gair says one last phrase.\n"
                                    + "Y�r, you're next!");
                            System.exit(0);
                        }
                    } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                        System.out.println("Too bad, there is no turning back now!\n");
                        Gair gair = new Gair();
                        Battle sequence = new Battle(Game.player, gair);
                        while (sequence.battle(Game.player, gair)) ;
                    } else {
                        System.out.print("See, all you had to do was follow instructions. Try that input again.\n");
                    }
                }
            }
        }
    }

    /**
     * Creates the game world
     */
    public Room createWorld() {
        createArtifacts();
        int newNum = rand.nextInt(artifacts.size());

        Room Awaken = new Room("first room of the dungeon", artifacts.get(newNum));
        artifacts.remove(newNum);

        Room Depths = new Room("depths of the dungeon", null);

        newNum = rand.nextInt(artifacts.size());
        Room ForbiddenPath = new Room("a small room with one door to exit, that's impossible to open", artifacts.get(newNum));
        artifacts.remove(newNum);

        Room MagicRoom = new Room("destroyed atreum of mages", null);

        newNum = rand.nextInt(artifacts.size());
        Room CouncilRoom = new Room("meeting room for the Council of Superiors", artifacts.get(newNum));
        artifacts.remove(newNum);

        Room Barracks = new Room("military quarters", null);

        newNum = rand.nextInt(artifacts.size());
        Room Throne = new Room("throne room of Y�r", artifacts.get(newNum));
        artifacts.remove(newNum);

        Room Hallway = new Room("hallway", null);
        Room Corridor = new Room("corridor connecting to the Throne Room", null);

        newNum = rand.nextInt(artifacts.size());
        Room Jail = new Room("the jail room", artifacts.get(newNum));
        artifacts.remove(newNum);

        Awaken.setExit("South", Depths);
        Awaken.setExit("East", Hallway);

        Depths.setExit("East", Barracks);
        Depths.setExit("North", Awaken);

        Hallway.setExit("South", Barracks);
        Hallway.setExit("East", MagicRoom);
        Hallway.setExit("West", Awaken);

        MagicRoom.setExit("North", ForbiddenPath);
        MagicRoom.setExit("West", Hallway);

        ForbiddenPath.setExit("South", MagicRoom);

        Barracks.setExit("West", Depths);
        Barracks.setExit("East", Corridor);
        Barracks.setExit("South", Jail);
        Barracks.setExit("North", Hallway);

        Jail.setExit("North", Barracks);

        Corridor.setExit("West", Barracks);
        Corridor.setExit("East", Throne);

        Throne.setExit("West", Corridor);
        Throne.setExit("South", CouncilRoom);

        CouncilRoom.setExit("North", Throne);

        return Awaken;
    }
}

