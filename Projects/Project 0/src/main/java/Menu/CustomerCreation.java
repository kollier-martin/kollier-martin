package Menu;

import DAOs.AccDAO;
import DAOs.CusDAO;
import DAOs.JunctionDAO;
import DAOs.UserDAO;
import Models.Account;
import Models.Customer;
import Models.Junction;
import Models.UserInfo;
import Utils.ConnectionManager;
import Utils.CredentialChecker;
import Utils.PrintManager;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerCreation extends PrintView {
    public CustomerCreation(Scanner scn) {
        super(CustomerCreation.class, scn);
    }

    @Override
    public void printMenu() {
        JunctionDAO jDAO = new JunctionDAO(ConnectionManager.conn);
        CusDAO cusDAO = new CusDAO(ConnectionManager.conn);
        UserDAO userDAO = new UserDAO(ConnectionManager.conn);
        AccDAO accDAO = new AccDAO(ConnectionManager.conn);

        boolean isCreatingAccount = true;
        CredentialChecker cc = new CredentialChecker();
        String email, firstName, lastName, newUserName, newPassword;

        PrintManager pm = PrintManager.getPM();
        Customer newCustomer = null;
        Account newAccount = null;

        System.out.println("============= ACCOUNT CREATION ===============");

        while (isCreatingAccount) {
            System.out.print("Enter your email: ");
            email = scn.nextLine();

            System.out.print("Enter your first name: ");
            firstName = scn.nextLine();

            System.out.print("Enter your last name: ");
            lastName = scn.nextLine();

            System.out.print("Enter your username: ");
            newUserName = scn.nextLine();

            System.out.print("Enter your password: ");
            newPassword = scn.nextLine();

            if (cc.isValid(newUserName, newPassword)) {
                // DAO saves called on successful account creation
                // All saves are in order to prevent foreign key constraint failures
                try {
                    newCustomer = new Customer(email, lastName, firstName);
                    newAccount = new Account("Checking", 0);

                    jDAO.save(new Junction(newAccount.getAccID(), newCustomer.getCusID()));

                    userDAO.save(new UserInfo(newUserName, newPassword));

                    cusDAO.save(newCustomer);

                    accDAO.save(newAccount);


                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Account creation failed due to database error.\n" +
                            "Would you like to try again? (Y/N): ");
                    String input = scn.nextLine();

                    if (input.equalsIgnoreCase("y")) {
                        break;
                    } else if (input.equalsIgnoreCase("n")) {
                        pm.navigate("class Menu.MainMenu");
                        break;
                    }
                }

                System.out.println("\nAccount creation successful! A new checking account has been created as a new customer courtesy.");
                System.out.print("Would you like to login now? ");

                String input = scn.nextLine();

                if (input.equalsIgnoreCase("y")) {
                    isCreatingAccount = false;

                    pm.setCurrentAccount(newAccount);
                    pm.setCurrentCustomer(newCustomer);

                    newAccount = null;
                    newCustomer = null;

                    pm.navigate("class Menu.Login");
                } else if (input.equalsIgnoreCase("n")) {
                    isCreatingAccount = false;

                    pm.navigate("class Menu.MainMenu");
                }
            } else {
                isCreatingAccount = true;
            }
        }
    }
}
