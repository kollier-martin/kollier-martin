package Menu;

import DAOs.AccDAO;
import DAOs.JunctionDAO;
import Models.Account;
import Models.Junction;
import Utils.ConnectionManager;

import java.sql.SQLException;
import java.util.Scanner;

public class AccountCreation extends PrintView {
    public AccountCreation(Scanner scn) {
        super(AccountCreation.class, scn);
    }

    @Override
    public void printMenu() throws SQLException {
        AccDAO accDAO = new AccDAO(ConnectionManager.conn);
        JunctionDAO jDAO = new JunctionDAO(ConnectionManager.conn);
        Account newAccount = new Account();
        boolean isCreatingAccount = true;
        String accountType, input;

        System.out.println("============= BANK ACCOUNT CREATION ===============");
        while (isCreatingAccount) {
            System.out.print("Input what kind of account you would like to make [Checking or Savings]: ");
            accountType = scn.nextLine();

            if (!(accountType.equalsIgnoreCase("Checking")) && !(accountType.equalsIgnoreCase("Savings"))) {
                System.out.println(accountType + " is an valid option. Try again.");
            } else {
                newAccount.setAccType(accountType);
                newAccount.setBalance(0);

                System.out.print("Would you like to name your account? (Y/N): ");
                input = scn.nextLine();

                switch (input) {
                    case "Y":
                    case "y":
                        System.out.print("Please enter the name for this account: ");
                        input = scn.nextLine();
                        newAccount.setAccountName(input);

                        jDAO.save(new Junction(newAccount.getAccID(), pm.getCurrentCustomer().getCusID()));
                        accDAO.save(newAccount);

                        System.out.println("Account creation successful!");
                        pm.navigate("class Menu.LoggedIn");
                        isCreatingAccount = false;
                        break;

                    case "N":
                    case "n":
                        jDAO.save(new Junction(newAccount.getAccID(), pm.getCurrentCustomer().getCusID()));
                        accDAO.save(newAccount);

                        System.out.println("Account creation successful!");
                        pm.navigate("class Menu.LoggedIn");
                        isCreatingAccount = false;
                        break;
                }
            }
        }
    }
}