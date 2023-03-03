package Menu;

import java.sql.SQLException;
import java.util.Scanner;

public class LoggedIn extends PrintView {
    public LoggedIn(Scanner scn) {
        super(LoggedIn.class, scn);
    }

    public void printMenu() throws SQLException {
        boolean isLoggedIn = true;

        while (isLoggedIn) {
            System.out.printf("\n============= %s's Account Page ===============" +
                    "\nEnter selection:" +
                    "\n\t1) Create New Bank Account" +
                    "\n\t2) Transfer Funds" +
                    "\n\t3) Deposit Funds" +
                    "\n\t4) Withdraw Funds" +
                    "\n\t5) View Account(s) Balance" +
                    "\n\t6) Print Transaction History" +
                    "\n\tQ) Quit to Main Menu\n", pm.getCurrentCustomer().getFirstName());

            System.out.print("-> ");
            String input = scn.nextLine();

            switch (input) {
                case "1":
                    pm.navigate("class Menu.AccountCreation");
                    isLoggedIn = false;
                    break;

                case "2":
                    pm.navigate("class Menu.TransferFunds");
                    isLoggedIn = false;
                    break;

                case "3":
                    pm.navigate("class Menu.DepositFunds");
                    isLoggedIn = false;
                    break;

                case "4":
                    pm.navigate("class Menu.WithdrawFunds");
                    isLoggedIn = false;
                    break;

                case "5":
                    pm.navigate("class Menu.AccountBalance");
                    isLoggedIn = false;
                    break;

                case "6":
                    pm.navigate("class Menu.TransactionHistory");
                    isLoggedIn = false;
                    break;

                case "q":
                case "Q":
                    System.out.println("Successfully logged out!\n");
                    pm.setCurrentCustomer(null);
                    pm.setCurrentAccount(null);
                    pm.navigate("class Menu.MainMenu");
                    isLoggedIn = false;
                    break;
            }
        }
    }
}
