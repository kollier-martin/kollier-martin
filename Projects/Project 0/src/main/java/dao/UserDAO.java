package dao;

import Models.UserInfo;
import MyCollections.MyArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements BankDAO<UserInfo> {
    /**
     * All SQL parameters used to run and store a query within the program
     */
    private String sql;
    private PreparedStatement pstmt = null;
    private Connection conn;
    private ResultSet rs = null;

    /**
     * Used to store a list of User Information
     */
    private MyArrayList<UserInfo> userInfoArrayList;

    /**
     * Used to store a row of UserInfo data
     */
    private UserInfo currentUser = null;


    public UserDAO(Connection conn) {
        userInfoArrayList = new MyArrayList<>();
        this.conn = conn;
    }

    /**
     * Saves a new data entry to the UserInfo table
     *
     * @param row UserInfo Object to pull data from
     * @throws SQLException
     */
    @Override
    public void save(UserInfo row) throws SQLException {
        sql = "INSERT INTO USERINFO(USERNAME, PASSWORD) VALUES (?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, row.getUSERNAME());
        pstmt.setString(2, row.getPASSWORD());
        pstmt.executeUpdate();
    }

    /**
     * Gets all UserInfo entries in table
     *
     * @return ArrayList of UserInfo objects
     * @throws SQLException
     */
    @Override
    public MyArrayList<UserInfo> getAll() throws SQLException {
        try {
            sql = "SELECT * FROM USERINFO";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                currentUser = new UserInfo(rs.getString("USERNAME"),
                        rs.getString("PASSWORD"));
                currentUser.setUserID(rs.getInt("USER_ID"));
                userInfoArrayList.add(currentUser);
            }
        } catch (SQLException e) {
            System.out.println("Incorrect table name. Can not fetch data from database.");
        }

        return userInfoArrayList;
    }

    /**
     * Delete UserInfo based on CUSTOMER_ID
     *
     * @param ID CUSTOMER_ID
     * @throws SQLException
     */
    @Override
    public void deleteByID(int ID) throws SQLException {
        sql = "DELETE * " +
                "FROM USERINFO u " +
                "JOIN CUSTOMERS c on c.USER_ID = u.USER_ID " +
                "JOIN AC_JUNCTION aj on c.CUSTOMER_ID = aj.CUSTOMER_ID " +
                "WHERE c.CUSTOMER_ID = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, ID);
        pstmt.executeUpdate(sql);
    }

    /**
     * Delete UserInfo based on USERNAME
     *
     * @param username USERNAME
     * @throws SQLException
     */
    public void deleteByUsername(String username) throws SQLException {
        sql = "ALTER TABLE CUSTOMERS " +
                "DROP CONSTRAINT IF EXISTS CJUNC_FK " +
                "DROP CONSTRAINT IF EXISTS C_UID";
        pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();

        sql = "DELETE FROM USERINFO " +
                "WHERE USERNAME = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.executeUpdate();
    }

    /**
     * Pulls an ArrayList of UserInfo, but there will only be one element every time
     *
     * @param ID CUSTOMER_ID
     * @return MyArrayList of UserInfo data
     * @throws SQLException
     */
    @Override
    public MyArrayList<UserInfo> getByID(int ID) throws SQLException {
        userInfoArrayList.clear();
        UserInfo temp = null;

        try {
            sql = "SELECT u.USER_NAME, u.PASSWORD, u.USER_ID" +
                    "FROM USERINFO u" +
                    "JOIN CUSTOMERS c ON c.USER_ID = u.USER_ID" +
                    "WHERE c.CUSTOMER_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ID);
            rs = pstmt.executeQuery();

            temp = new UserInfo(rs.getString("USER_NAME"),
                    rs.getString("PASSWORD"));
            temp.setUserID(rs.getInt("USER_ID"));

            userInfoArrayList.add(temp);

        } catch (SQLException e) {
            System.out.println("Table is not properly formatted or is invalid. Can not fetch data.");
        }

        return userInfoArrayList;
    }

}
