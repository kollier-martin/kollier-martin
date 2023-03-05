package Menu;

import Models.Account;
import Models.Transaction;
import MyCollections.MyArrayList;
import Utils.ConnectionManager;
import dao.AccDAO;
import dao.TransactionDAO;

import java.sql.Date;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class DepositFunds extends PrintView {
    public DepositFunds(Scanner scn) {
        super(DepositFunds.class, scn);
    }

    @Override
    public void printMenu() throws SQLException {
        Date sqlDate = new Date(System.currentTimeMillis());
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

        TransactionDAO tDAO = new TransactionDAO(ConnectionManager.conn);
        AccDAO accDAO = new AccDAO(ConnectionManager.conn);

        MyArrayList<Account> accounts;
        MyArrayList<Integer> accountIDs = new MyArrayList<>();

        int amount, startingBalance, endingBalance = 0;
        String accountID, depositStatus = "";

        System.out.printf("\n============= %s's Deposit Page ===============" +
                "\nDeposit Funds Into Which Account:", pm.getCurrentCustomer().getFirstName());

        try {
            accounts = accDAO.getAllByFirstName(pm.getCurrentCustomer().getFirstName());
            for (int i = 0; i < accounts.length(); i++) {
                System.out.printf("\n\t%d - Current Balance: [%s]", accounts.get(i).getAccID(), formatter.format(accounts.get(i).getBalance()));
                accountIDs.add(accounts.get(i).getAccID());
            }
            System.out.print("\n-> ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        accountID = scn.nextLine();

        // Turn input into an integer, Use for validation
        int accountIDInt = Integer.parseInt(accountID);

        // Input is not a valid account number
        if (!accountIDs.contains(accountIDInt)) {
            System.out.println("This is not a valid account number. Try again.");
        } else {
            System.out.print("Enter deposit amount: ");
            String input = scn.nextLine();
            amount = Integer.parseInt(input);

            startingBalance = accDAO.getAccByID(accountIDInt).getBalance();

            if (amount < 0) {
                System.out.println("Amount " + amount + " is not a positive value.");
            } else {
                if (accDAO.depositFunds(amount, accountIDInt)) {
                    endingBalance = accDAO.getAccByID(accountIDInt).getBalance();

                    depositStatus = ("Deposit Successful - Old Balance: " + formatter.format(startingBalance) +
                            ", New Balance: " + formatter.format(endingBalance));

                    tDAO.save(new Transaction(accountIDInt, accountIDInt, sqlDate, startingBalance, endingBalance, depositStatus));
                    pm.navigate("class Menu.LoggedIn");
                }
            }
        }
    }
}

