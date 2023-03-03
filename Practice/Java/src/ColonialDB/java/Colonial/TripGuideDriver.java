package Colonial;

/*
 * Kyle's code to show how to print out specific data based on the SQL table
 *
 */

import Interfaces.DBInterface;
import Objects.TripGuides;
import Utils.ConnectionManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TripGuideDriver implements DBInterface {
    public static void run() {
        TripGuides temp;
        Connection conn = null;

        try {
            conn = ConnectionManager.getConn();

            String sqlInfo = "SELECT * FROM TRIP_GUIDES"; // SQL statement to run
            Statement stmt = conn.createStatement(); // Used for query execution
            ResultSet rs = stmt.executeQuery((sqlInfo)); // Executes the designated query and stores the values into 'rs'
            List<TripGuides> resultList = new ArrayList<>();

            while (rs.next()) {
                temp = new TripGuides(rs.getInt("TRIP_ID"),
                        rs.getString("GUIDE_NUM"));

                resultList.add(temp);
            }

            for (TripGuides tm : resultList) {
                System.out.println(tm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

