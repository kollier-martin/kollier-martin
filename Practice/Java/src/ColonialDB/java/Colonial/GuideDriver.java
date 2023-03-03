package Colonial;

/*
 * Driver code to print out data based on the Guide table
 *
 */

import Interfaces.DBInterface;
import Objects.Guide;
import Utils.ConnectionManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GuideDriver implements DBInterface {
    public static void run() {
        Guide temp;
        Connection conn = null;

        try {
            conn = ConnectionManager.getConn();

            String sqlInfo = "SELECT * FROM GUIDE"; // SQL statement to run
            Statement stmt = conn.createStatement(); // Used for query execution
            ResultSet rs = stmt.executeQuery((sqlInfo)); // Executes the designated query and stores the values into 'rs'
            List<Guide> resultList = new ArrayList<>();

            while (rs.next()) {
                temp = new Guide(rs.getString("GUIDE_NUM"),
                        rs.getString("LAST_NAME"),
                        rs.getString("ADDRESS"),
                        rs.getString("FIRST_NAME"),
                        rs.getString("CITY"),
                        rs.getString("STATE"),
                        rs.getString("POSTAL_CODE"),
                        rs.getString("PHONE_NUM"),
                        rs.getString("HIRE_DATE"));

                resultList.add(temp);
            }

            for (Guide tm : resultList) {
                System.out.println(tm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
