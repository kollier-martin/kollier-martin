/**
 * Accounts DAO, Data Access Object
 * Class that contains operations to access ACCOUNTS information from ~DB~.Accounts
 *
 * @author Kollier Martin
 * @date
 */

package dao;

import Models.Account;
import MyCollections.MyArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

public class AccDAO implements BankDAO<Account> {
    /**
     * Used to store a list of customers in function getAllCustomers()
     */
    private MyArrayList<Account> accounts;

    /**
     * Used to store a single customer in function getCustomerByID(int ID)
     */
    private Account currentAccount = null;

    /**
     * All SQL parameters used to run and store a query within the program
     */
    private String sql = "";
    private PreparedStatement pstmt = null;
    private Connection conn = null;
    private ResultSet rs = null;

    /**
     * Parameterized Constructor that is used to create an Account DAO object
     * On creation, this constructor initializes the 'customers' list as an ArrayList and assigns 'this.conn' as the given conn parameter
     *
     * @param conn
     */
    public AccDAO(Connection conn) {
        accounts = new MyArrayList<>();
        this.conn = conn;
    }

    /**
     * This method simply creates or updates data for an account in the Accounts table
     * Either Create or Update:
     * ACCOUNT_ID with getAccID given from parameter
     * CUSTOMER_ID with getCustID given from parameter
     * BALANCE with getBalance given from parameter
     *
     * @param rowData
     * @throws SQLException
     */
    @Override
    public void save(Account rowData) throws SQLException {
        sql = "INSERT INTO ACCOUNTS(ACCOUNT_NAME, ACCOUNT_ID, ACCOUNT_TYPE, BALANCE)" +
                "VALUES (?, ?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, rowData.getAccountName());
        pstmt.setInt(2, rowData.getAccID());
        pstmt.setString(3, rowData.getAccType());
        pstmt.setInt(4, rowData.getBalance());
        pstmt.executeUpdate();
    }

    /**
     * This method returns row data of an Account(s) depending on the ACCOUNT_ID column, based on the id parameter:
     *
     * @param ID
     * @return Row data of an Account from the ACCOUNT_ID column based on the id parameter
     * @throws SQLException
     */
    @Override
    public MyArrayList<Account> getByID(int ID) throws SQLException {
        accounts.clear();
        sql = "SELECT * FROM ACCOUNTS a WHERE a.ACCOUNT_ID = ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, ID);

        rs = pstmt.executeQuery();

        while (rs.next()) {
            currentAccount = new Account(rs.getString("ACCOUNT_NAME"),
                    rs.getString("ACCOUNT_TYPE"),
                    rs.getInt("BALANCE"));
            accounts.add(currentAccount);
        }

        return accounts;
    }

    /**
     * This method returns row data of an Account depending on the ACCOUNT_ID column, based on the id parameter:
     *
     * @param ID
     * @return Row data of an Account from the ACCOUNT_ID column based on the id parameter
     * @throws SQLException
     */
    public Account getAccByID(int ID) throws SQLException {
        accounts.clear();
        sql = "SELECT * FROM ACCOUNTS a WHERE a.ACCOUNT_ID = ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, ID);

        rs = pstmt.executeQuery();

        while (rs.next()) {
            currentAccount = new Account(rs.getString("ACCOUNT_NAME"),
                    rs.getInt("ACCOUNT_ID"),
                    rs.getString("ACCOUNT_TYPE"),
                    rs.getInt("BALANCE"));
        }

        return currentAccount;
    }

    /**
     * This method returns every piece of data from the ACCOUNTS table
     *
     * @return Every piece of data from the ACCOUNTS table
     * @throws SQLException
     */
    @Override
    public MyArrayList<Account> getAll() throws SQLException {
        sql = "SELECT * FROM ACCOUNTS";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            currentAccount = new Account(rs.getString("ACCOUNT_NAME"),
                    rs.getString("ACCOUNT_TYPE"),
                    rs.getInt("BALANCE"));

            accounts.add(currentAccount);
        }

        return accounts;
    }

    /**
     * This method deletes an account on the ACCOUNTS table using its ACCOUNT_ID field
     *
     * @param ID
     * @throws SQLException
     */
    @Override
    public void deleteByID(int ID) throws SQLException {
        sql = "DELETE ACCOUNTS a FROM ACCOUNTS" +
                "WHERE a.ACCOUNT_ID = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, ID);
        rs = pstmt.executeQuery();
    }

    /**
     * This method returns an Account(s) from the ACCOUNTS table
     *
     * @param firstName customer first name to pull data by
     * @return
     * @throws SQLException
     */
    public MyArrayList<Account> getAllByFirstName(String firstName) throws SQLException {
        accounts.clear();
        sql = "SELECT * " +
                "FROM ACCOUNTS a " +
                "JOIN AC_JUNCTION aj ON a.ACCOUNT_ID = aj.ACCOUNT_ID " +
                "JOIN CUSTOMERS c ON c.CUSTOMER_ID = aj.CUSTOMER_ID " +
                "JOIN USERINFO u ON u.USER_ID = c.USER_ID " +
                "WHERE c.FIRST_NAME = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, firstName);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            accounts.add(new Account(rs.getString("ACCOUNT_NAME"),
                    rs.getInt("ACCOUNT_ID"),
                    rs.getString("ACCOUNT_TYPE"),
                    rs.getInt("BALANCE")));
        }

        return accounts;
    }

    /**
     * This method returns an Account(s) from the ACCOUNTS table
     *
     * @param username username to pull data by
     * @return
     * @throws SQLException
     */
    public MyArrayList<Account> getAllByUsername(String username) throws SQLException {
        accounts.clear();
        sql = "SELECT * " +
                "FROM ACCOUNTS a " +
                "JOIN AC_JUNCTION aj ON a.ACCOUNT_ID = aj.ACCOUNT_ID " +
                "JOIN CUSTOMERS c ON c.CUSTOMER_ID = aj.CUSTOMER_ID " +
                "JOIN USERINFO u ON u.USER_ID = c.USER_ID " +
                "WHERE u.USERNAME = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        rs = pstmt.executeQuery();

        MyArrayList<Account> myAccounts = new MyArrayList<>();

        while (rs.next()) {
            myAccounts.add(new Account(rs.getString("ACCOUNT_NAME"),
                    rs.getInt("ACCOUNT_ID"),
                    rs.getString("ACCOUNT_TYPE"),
                    rs.getInt("BALANCE")));
        }

        return myAccounts;
    }

    /**
     * Method to withdraw funds from an Account
     *
     * @param amount Amount to withdraw
     * @param accID  Account to store the withdrawn money
     * @return
     */
    public boolean withdrawFunds(int amount, int accID) {
        boolean success = false;

        try {
            if (amount > getAccByID(accID).getBalance()) {
                System.out.println("You have insufficient funds for this transaction.");
                success = false;
            } else {
                sql = "UPDATE ACCOUNTS " +
                        "SET BALANCE = (BALANCE - ?) " +
                        "WHERE ACCOUNT_ID = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, amount);
                pstmt.setInt(2, accID);

                if (pstmt.executeUpdate() != 0) {
                    success = true;
                }
            }
        } catch (SQLException e) {
            System.out.println(NullAccount(accID));
            e.printStackTrace();
            success = false;
        }

        return success;
    }

    /**
     * Method to deposit funds to an Account
     *
     * @param amount Amount to deposit
     * @param accID  Account to store the deposited money
     * @return
     * @throws SQLException
     */
    public boolean depositFunds(int amount, int accID) throws SQLException {
        boolean success = false;

        sql = "UPDATE ACCOUNTS a " +
                "SET a.BALANCE = (a.BALANCE + ?) " +
                "WHERE a.ACCOUNT_ID = ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, amount);
        pstmt.setInt(2, accID);

        if (pstmt.executeUpdate() != 0) {
            success = true;
        }

        return success;
    }

    /**
     * Called to transfer funds between two accounts
     *
     * @param amount     Amount to be transferred
     * @param accID      Account to deduct the amount from
     * @param otherAccID Account to add the amount to
     * @return
     */
    public boolean transferFunds(int amount, int accID, int otherAccID) {
        boolean success = false;
        if (withdrawFunds(amount, accID)) {
            NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
            try {
                sql = "UPDATE ACCOUNTS " +
                        "SET BALANCE = (BALANCE + ?) " +
                        "WHERE ACCOUNT_ID = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, amount);
                pstmt.setInt(2, otherAccID);

                if (pstmt.executeUpdate() != 0) {
                    System.out.println(formatter.format(amount) + " has been deposited to Account: " + otherAccID);
                    success = true;
                }
            } catch (SQLException e) {
                System.out.println(NullAccount(otherAccID));
                e.printStackTrace();
                success = false;
            }
        }

        return success;
    }

    /**
     * Error message for a null Account
     *
     * @param accID The account id that is not valid
     * @return
     */
    private String NullAccount(int accID) {
        return "Account with ID : " + accID + " does not exist.";
    }
}
