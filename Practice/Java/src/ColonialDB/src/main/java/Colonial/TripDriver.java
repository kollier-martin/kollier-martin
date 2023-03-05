package Colonial;

/*
 * Kyle's code to show how to print out specific data based on the SQL table
 *
 */

import Objects.Trip;
import Utils.ConnectionManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TripDriver {
    public static void run() {
        Trip temp;
        Connection conn;

        try {
            conn = ConnectionManager.getConn();

            String sqlInfo = "SELECT * FROM TRIP"; // SQL statement to run
            Statement stmt = conn.createStatement(); // Used for query execution
            ResultSet rs = stmt.executeQuery((sqlInfo)); // Executes the designated query and stores the values into 'rs'
            List<Trip> resultList = new ArrayList<>();

            while (rs.next()) {
                temp = new Trip(rs.getString("STATE"),
                        rs.getString("START_LOCATION"),
                        rs.getString("TRIP_NAME"),
                        rs.getString("ACTIVITY"),
                        rs.getString("SEASON"),
                        rs.getInt("TRIP_ID"),
                        rs.getInt("DISTANCE"),
                        rs.getInt("MAX_GRP_SIZE"));

                resultList.add(temp);
            }

            for (Trip tm : resultList) {
                System.out.println(tm);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
