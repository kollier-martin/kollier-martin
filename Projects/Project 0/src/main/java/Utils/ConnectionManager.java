/*
 * Return connection to a DB
 *
 */

package Utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    public static Connection conn;
    private static String myDBProp = "src/main/resources/db_properties.properties";

    private ConnectionManager() {

    }

    public static void getConn() {
        try {
            if (conn == null) {
                Properties prop = new Properties();
                // Change me dependent on property file to attack
                FileReader propertiesFile = new FileReader(myDBProp);
                prop.load(propertiesFile);

                String connString = "jdbc:mariadb://" +
                        prop.getProperty("hostname") + ":" +
                        prop.getProperty("port") + "/" +
                        prop.getProperty("databaseName") + "?user=" +
                        prop.getProperty("user") + "&password=" +
                        prop.getProperty("password");

                conn = DriverManager.getConnection(connString);
            }
        } catch (SQLException | IOException e) {
            System.out.println("Connection to database can not be established!\n" + e + "\nShutting down.");
            System.exit(0);
        }
    }
}
