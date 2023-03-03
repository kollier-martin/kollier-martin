package DAOs;

import MyCollections.MyArrayList;
import Models.Junction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JunctionDAO implements BankDAO<Junction> {
    /**
     * Used to store a list of junctions
     */
    private MyArrayList<Junction> junctions;

    /**
     * Used to store a single junction
     */
    private Junction currentJunction = null;

    /**
     * All SQL parameters used to run and store a query within the program
     */
    private String sql;
    private PreparedStatement pstmt = null;
    private Connection conn;
    private ResultSet rs = null;

    /**
     * Parameterized Constructor that is used to create a Junction DAO
     * On creation, this constructor initializes the 'junctions' list as an ArrayList and assigns 'this.conn' as the given conn parameter
     *
     * @param conn
     */
    public JunctionDAO(Connection conn) {
        junctions = new MyArrayList<>();
        this.conn = conn;
    }

    /**
     * This method simply creates or updates data for a Junction in the AC_JUNCTION table
     * Either Create or Update:
     * ACCOUNT_ID with getAccountID() called on parameter
     * CUSTOMER_ID with getCustomerID called on parameter
     *
     * @param rowData
     * @throws SQLException
     */
    @Override
    public void save(Junction rowData) throws SQLException {
        sql = "INSERT INTO AC_JUNCTION(ACCOUNT_ID, CUSTOMER_ID) VALUES (?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, rowData.getAccountID());
        pstmt.setInt(2, rowData.getCustomerID());
        pstmt.executeUpdate();
    }

    /**
     * This method returns row data of a Junction depending on the CUSTOMER_ID column, based on the id parameter
     *
     * @param ID Junction_ID
     * @return Row data of a Junction from the CUSTOMER_ID column based on the id parameter
     * @throws SQLException
     */
    @Override
    public MyArrayList<Junction> getByID(int ID) throws SQLException {
        junctions.clear();
        sql = "SELECT * FROM AC_JUNCTION aj" +
                "WHERE aj.CUSTOMER_ID = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, ID);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            currentJunction = new Junction(rs.getInt("JUNCTION_ID"),
                    rs.getInt("ACCOUNT_ID"),
                    rs.getInt("CUSTOMER_ID"));

            junctions.add(currentJunction);
        }

        return junctions;
    }

    /**
     * This method returns every piece of data from the AC_JUNCTION table
     *
     * @return Every piece of data from the AC_JUNCTION table
     * @throws SQLException
     */
    @Override
    public MyArrayList<Junction> getAll() {
        try {
            sql = "SELECT * FROM AC_JUNCTION";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                currentJunction = new Junction(rs.getInt("JUNCTION_ID"),
                        rs.getInt("ACCOUNT_ID"),
                        rs.getInt("CUSTOMER_ID"));
                junctions.add(currentJunction);
            }
        } catch (SQLException e) {
            System.out.println("Incorrect table name. Can not fetch data from database.");
        }

        return junctions;
    }

    /**
     * This method deletes data on the AC_JUNCTION table using its JUNCTION_ID field
     *
     * @param JUNCTION_ID JUNCTION_ID to delete by
     * @throws SQLException
     */
    @Override
    public void deleteByID(int JUNCTION_ID) throws SQLException {
        sql = "DELETE AC_JUNCTION FROM AC_JUNCTION aj" +
                "WHERE aj.JUNCTION_ID = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, JUNCTION_ID);
        rs = pstmt.executeQuery();
    }
}
