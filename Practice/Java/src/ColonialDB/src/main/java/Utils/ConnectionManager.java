/*
 * Kyle's code to show to connect to a DB
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
    private static final String DB_PROPERTIES = "src/main/resources/db_properties.properties";
    private static Connection conn;

    private ConnectionManager() throws IllegalAccessException {
        throw new IllegalAccessException("ConnectionManager can not be instantiated");
    }

    public static Connection getConn() throws SQLException, IOException {
        if (conn == null) {
            Properties prop = new Properties();
            // Change me dependent on property file to attack
            FileReader propertiesFile = new FileReader(DB_PROPERTIES);
            prop.load(propertiesFile);

            String connString = "jdbc:h2:mem://" +
                    prop.getProperty("databaseName") + "?user=" +
                    prop.getProperty("user") + "&password=" +
                    prop.getProperty("password");

            conn = DriverManager.getConnection(connString);
        }

        return conn;
    }
}
