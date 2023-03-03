package Menu;

import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu extends PrintView {

    public MainMenu(Scanner scn) {
        super(MainMenu.class, scn);
    }

    @Override
    public void printMenu() throws SQLException {
        System.out.println("============= MAIN MENU ===============" +
                "\nEnter selection:" +
                "\n\t1) Login" +
                "\n\t2) Create an Account" +
                "\n\tQ) Quit Application");
        System.out.print("-> ");
        String input = scn.nextLine();

        switch (input) {
            case "1":
                pm.navigate("class Menu.Login");
                break;
            case "2":
                pm.navigate("class Menu.CustomerCreation");
                break;
            case "q":
            case "Q":
                scn.close();
                System.out.println("Closing Application. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("This is not a valid menu input!");
                break;
        }
    }
}
