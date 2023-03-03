package Menu;

import DAOs.TransactionDAO;
import Utils.ConnectionManager;

import java.sql.SQLException;
import java.util.Scanner;

public class TransactionHistory extends PrintView {

    public TransactionHistory(Scanner scn) {
        super(TransactionHistory.class, scn);
    }

    @Override
    public void printMenu() throws SQLException {
        TransactionDAO tDao = new TransactionDAO(ConnectionManager.conn);

        tDao.getAllByCID(pm.getCurrentCustomer().getCusID());

        pm.navigate("class Menu.LoggedIn");
    }
}
