package Colonial;

/*
 * Driver code to print out data based on the Reservation table
 *
 */

import Objects.Reservation;
import Utils.ConnectionManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReservationDriver {
    public static void run() {
        Reservation temp;
        Connection conn;

        try {
            conn = ConnectionManager.getConn();

            String sqlInfo = "SELECT * FROM RESERVATION"; // SQL statement to run
            Statement stmt = conn.createStatement(); // Used for query execution
            ResultSet rs = stmt.executeQuery((sqlInfo)); // Executes the designated query and stores the values into 'rs'
            List<Reservation> resultList = new ArrayList<>();

            while (rs.next()) {
                temp = new Reservation(rs.getString("RESERVATION_ID"),
                        rs.getString("CUSTOMER_NUM"),
                        rs.getString("TRIP_DATE"),
                        rs.getInt("TRIP_ID"),
                        rs.getInt("NUM_PERSONS"),
                        rs.getFloat("TRIP_PRICE"),
                        rs.getFloat("OTHER_FEES"));

                resultList.add(temp);
            }

            for (Reservation tm : resultList) {
                System.out.println(tm);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
