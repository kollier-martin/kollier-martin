package Utils;

import Menu.AccountBalance;
import Menu.AccountCreation;
import Menu.CustomerCreation;
import Menu.DepositFunds;
import Menu.LoggedIn;
import Menu.Login;
import Menu.MainMenu;
import Menu.PrintView;
import Menu.TransactionHistory;
import Menu.TransferFunds;
import Menu.WithdrawFunds;
import Models.Account;
import Models.Customer;
import MyCollections.MyArrayList;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class PrintManager {
    private static PrintManager pm;
    public MyArrayList<PrintView> menuList;
    private Connection conn;
    private Scanner scn;
    private Customer currentCustomer;
    private Account currentAccount;
    private PrintView nextMenu;

    public PrintManager() {
        pm = this;

        this.scn = new Scanner(System.in);
        this.conn = ConnectionManager.conn;

        menuList = new MyArrayList<>();

        menuList.add(new AccountBalance(scn));
        menuList.add(new TransactionHistory(scn));
        menuList.add(new TransferFunds(scn));
        menuList.add(new WithdrawFunds(scn));
        menuList.add(new DepositFunds(scn));
        menuList.add(new CustomerCreation(scn));
        menuList.add(new AccountCreation(scn));
        menuList.add(new LoggedIn(scn));
        menuList.add(new Login(scn));
        menuList.add(new MainMenu(scn));
    }

    public static PrintManager getPM() {
        if (pm == null) {
            pm = new PrintManager();
        }

        return pm;
    }

    /**
     * Navigates to a specific menu dependent on the destination parameter
     *
     * @param destination
     */
    public void navigate(String destination) {
        for (PrintView menu : menuList) {
            if (menu.getViewerType().toString().equals(destination)) {
                nextMenu = menu;
            }
        }
    }

    public void printThis() throws SQLException {
        nextMenu.printMenu();
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer c) {
        this.currentCustomer = c;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(Account a) {
        this.currentAccount = a;
    }
}

