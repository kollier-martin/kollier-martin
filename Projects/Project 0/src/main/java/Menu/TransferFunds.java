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

public class TransferFunds extends PrintView {

    public TransferFunds(Scanner scn) {
        super(TransferFunds.class, scn);
    }

    @Override
    public void printMenu() throws SQLException {
        Date sqlDate = new Date(System.currentTimeMillis());
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

        AccDAO accDAO = new AccDAO(ConnectionManager.conn);
        TransactionDAO tDAO = new TransactionDAO(ConnectionManager.conn);

        MyArrayList<Account> accounts;

        boolean isTransferring = true;

        String amount, accID, sendToID;
        int amountI, accIDI, sendToIDI;

        System.out.printf("\n============= %s's Transfer Page ===============", pm.getCurrentCustomer().getFirstName());


        while (isTransferring) {
            System.out.println("\nBalance for Account(s):");
            try {
                accounts = accDAO.getAllByFirstName(pm.getCurrentCustomer().getFirstName());

                // Print available accounts
                for (Account acc : accounts) {
                    System.out.printf("\t%d : [%s]", acc.getAccID(), formatter.format(acc.getBalance()));
                }

                System.out.println();

                System.out.print("Choose the account in which you would like to transfer from: ");
                accID = scn.nextLine();

                System.out.print("Input transfer amount: ");
                amount = scn.nextLine();

                System.out.print("Input any Account ID from within the database where you would like to transfer: ");
                sendToID = scn.nextLine();

                accIDI = Integer.parseInt(accID);
                sendToIDI = Integer.parseInt(sendToID);
                amountI = Integer.parseInt(amount);

                int transactionOB = accDAO.getAccByID(accIDI).getBalance();
                int transactionNB = accDAO.getAccByID(accIDI).getBalance() + amountI;

                // Transfer Funds
                if (accDAO.transferFunds(amountI, accIDI, sendToIDI)) {
                    // Store Transaction
                    tDAO.save(new Transaction(sendToIDI,
                            accIDI,
                            sqlDate,
                            transactionOB,
                            transactionNB,
                            ("Successfully transferred " + formatter.format(amountI) + " to Account: " + sendToIDI + "! " +
                                    "Old Balance: " + formatter.format(transactionOB) +
                                    ", New Balance: " + formatter.format(transactionNB))));

                    pm.navigate("class Menu.LoggedIn");
                    isTransferring = false;
                } else {
                    pm.navigate("class Menu.LoggedIn");
                    isTransferring = false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
