/**
 * Customers DAO, Data Access Object
 * Class that contains operations to access CUSTOMERS information from ~DB~.Accounts
 *
 * @author Kollier Martin
 * @date
 */

package dao;

import Models.Customer;
import MyCollections.MyArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CusDAO implements BankDAO<Customer> {
    /**
     * Used to store a list of customers in function getAllCustomers()
     */
    private MyArrayList<Customer> customers;

    /**
     * Used to store a single customer in function getCustomerByID(int ID)
     */
    private Customer currentCustomer = null;

    /**
     * All SQL parameters used to run and store a query within the program
     */
    private String sql;
    private PreparedStatement pstmt = null;
    private Connection conn;
    private ResultSet rs = null;

    /**
     * Parameterized Constructor that is used to create a Customer DAO object
     * On creation, this constructor initializes the 'customers' list as an ArrayList and assigns 'this.conn' as the given conn parameter
     *
     * @param conn
     */
    public CusDAO(Connection conn) {
        customers = new MyArrayList<>();
        this.conn = conn;
    }

    /**
     * This method simply creates or updates data for an account in the Accounts table
     * <p>
     * CUSTOMER_ID with getCusID given from parameter
     * EMAIL with getEMAIL given from parameter
     * LAST_NAME with getLastName given from parameter
     * FIRST_NAME with getFirstName given from parameter
     *
     * @param rowData Customer object to receive data from
     * @throws SQLException
     */
    @Override
    public void save(Customer rowData) throws SQLException {
        sql = "INSERT INTO CUSTOMERS(CUSTOMER_ID, EMAIL, LAST_NAME, FIRST_NAME) VALUES (?, ?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, rowData.getCusID());
        pstmt.setString(2, rowData.getEMAIL());
        pstmt.setString(3, rowData.getLastName());
        pstmt.setString(4, rowData.getFirstName());
        pstmt.executeUpdate();
    }

    /**
     * This method returns row data of a Customer depending on the CUSTOMER_ID column, based on the id parameter
     *
     * @param ID
     * @return A list of row data of a Customer from the CUSTOMER_ID column based on the id parameter
     * @throws SQLException
     */
    @Override
    public MyArrayList<Customer> getByID(int ID) throws SQLException {
        customers.clear();
        sql = "SELECT CUSTOMERS c FROM CUSTOMERS" +
                "WHERE c.CUSTOMER_ID = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, ID);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            currentCustomer = new Customer(rs.getInt("CUSTOMER_ID"),
                    rs.getString("EMAIL"),
                    rs.getString("LAST_NAME"),
                    rs.getString("FIRST_NAME"));

            customers.add(currentCustomer);
        }

        return customers;
    }

    /**
     * This method returns every piece of data from the CUSTOMERS table
     *
     * @return Every piece of data from the CUSTOMERS table
     * @throws SQLException
     */
    @Override
    public MyArrayList<Customer> getAll() {
        try {
            sql = "SELECT * FROM CUSTOMERS";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                currentCustomer = new Customer(rs.getInt("CUSTOMER_ID"),
                        rs.getString("EMAIL"), rs.getString("LAST_NAME"),
                        rs.getString("FIRST_NAME"));
                customers.add(currentCustomer);
            }
        } catch (SQLException e) {
            System.out.println("Incorrect table name. Can not fetch data from database.");
        }

        return customers;
    }

    /**
     * This method deletes a Customer on the CUSTOMERS table using its CUSTOMER_ID field
     *
     * @param ID
     * @throws SQLException
     */
    @Override
    public void deleteByID(int ID) throws SQLException {
        sql = "DELETE CUSTOMERS c FROM CUSTOMERS" +
                "WHERE c.CUSTOMER_ID = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, ID);
        rs = pstmt.executeQuery();

    }

    /**
     * This method returns row data of a Customer depending on the CUSTOMER_ID column, based on the id parameter
     *
     * @param username
     * @return Row data of a Customer from the username column based on the id parameter
     * @throws SQLException
     */
    public Customer getByName(String username) throws SQLException {
        sql = "SELECT * " +
                "FROM CUSTOMERS c " +
                "JOIN USERINFO u ON c.USER_ID = u.USER_ID " +
                "WHERE u.USERNAME = ? ";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            currentCustomer = new Customer(rs.getInt("CUSTOMER_ID"),
                    rs.getString("EMAIL"),
                    rs.getString("LAST_NAME"),
                    rs.getString("FIRST_NAME"));
        }

        return currentCustomer;
    }

}
