package Menu;

import DAOs.AccDAO;
import DAOs.TransactionDAO;
import MyCollections.MyArrayList;
import Models.Account;
import Models.Transaction;
import Utils.ConnectionManager;

import java.sql.Date;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class WithdrawFunds extends PrintView {
    public WithdrawFunds(Scanner scn) {
        super(WithdrawFunds.class, scn);
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

        System.out.printf("\n============= %s's Withdraw Page ===============" +
                "\nWithdraw Funds From Which Account:", pm.getCurrentCustomer().getFirstName());

        try {
            accounts = accDAO.getAllByFirstName(pm.getCurrentCustomer().getFirstName());
            for (int i = 0; i < accounts.length(); i++) {
                System.out.printf("\n\t%d - Current Balance: [%s]", accounts.get(i).getAccID(), formatter.format(accounts.get(i).getBalance()));
                accountIDs.add(accounts.get(i).getAccID());
            }
            System.out.println(" ");
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
            System.out.println("Enter withdraw amount: ");
            String input = scn.nextLine();
            amount = Integer.parseInt(input);

            startingBalance = accDAO.getAccByID(accountIDInt).getBalance();

            if (amount > startingBalance) {
                System.out.println("You have insufficient funds to withdraw " + amount + ".");
                pm.navigate("class Menu.LoggedIn");
            } else {
                endingBalance = accDAO.getAccByID(accountIDInt).getBalance() - amount;

                if (accDAO.withdrawFunds(amount, accountIDInt)) {

                    depositStatus = ("Withdraw Successful - " +
                            "Old Balance: " + formatter.format(startingBalance) +
                            ", New Balance: " + formatter.format(endingBalance));

                    System.out.println(depositStatus);

                    tDAO.save(new Transaction(accountIDInt, accountIDInt, sqlDate, startingBalance, endingBalance, depositStatus));
                }
            }
            pm.navigate("class Menu.LoggedIn");
        }
    }
}
