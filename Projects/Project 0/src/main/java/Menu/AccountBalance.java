package Menu;

import Models.Account;
import MyCollections.MyArrayList;
import Utils.ConnectionManager;
import dao.AccDAO;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class AccountBalance extends PrintView {
    public AccountBalance(Scanner scn) {
        super(AccountBalance.class, scn);
    }

    @Override
    public void printMenu() throws SQLException {
        AccDAO accDAO = new AccDAO(ConnectionManager.conn);
        MyArrayList<Account> accounts;
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

        System.out.printf("\n============= %s's Balances Page ===============" +
                "\nBalance for Account(s):", pm.getCurrentCustomer().getFirstName());

        try {
            accounts = accDAO.getAllByFirstName(pm.getCurrentCustomer().getFirstName());
            for (Account acc : accounts) {
                System.out.printf("\n\t'%s' {%s} %d : [%s]", acc.getAccountName(), acc.getAccType(),
                        acc.getAccID(), formatter.format(acc.getBalance()));
            }
            System.out.println("\n=====================================================");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        pm.navigate("class Menu.LoggedIn");
    }
}
