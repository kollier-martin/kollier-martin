package Colonial;

/*
 * Driver code to print out data based on the Customer table
 *
 */

import Utils.ConnectionManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDriver
{
    public static void main (String args[])
    {
        Customer temp;
        Connection conn = null;

        try
        {
            conn = ConnectionManager.getConn();

            String sqlInfo = "SELECT * FROM CUSTOMER"; // SQL statement to run
            Statement stmt = conn.createStatement(); // Used for query execution
            ResultSet rs = stmt.executeQuery((sqlInfo)); // Executes the designated query and stores the values into 'rs'
            List<Customer> resultList = new ArrayList<>();

            while (rs.next())
            {
                temp = new Customer(rs.getString("CUSTOMER_NUM"),
                        rs.getString("LAST_NAME"),
                        rs.getString("ADDRESS"),
                        rs.getString("FIRST_NAME"),
                        rs.getString("CITY"),
                        rs.getString("STATE"),
                        rs.getString("POSTAL_CODE"),
                        rs.getString("PHONE"));

                resultList.add(temp);
            }

            for ( Customer tm : resultList )
            {
                System.out.println(tm);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
