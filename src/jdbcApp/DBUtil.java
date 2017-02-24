/**
 * Obligatorisk Opgave 3, 2 SEM
 * @author Mads Heilberg
 */
package jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class returns a connection type based on the identifiers and process
 * exceptions.
 */

public class DBUtil {
    //saves login information as constants
    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "dbpassword";
    private static final String HSQL_URL = "jdbc:hsqldb:data/explorecalifornia";
    private static final String MSQL_URL = "jdbc:mysql://localhost/explorecalifornia";
    
    public static Connection getConnection(DBType dbType) throws SQLException{
        //returns a connection type to the database requested
        Connection conn;
        switch (dbType){
            case MYSQL_DB: conn = DriverManager.getConnection(MSQL_URL, USERNAME, PASSWORD); break;
            case HSQL_DB: conn = DriverManager.getConnection(HSQL_URL, USERNAME, PASSWORD); break;
            default: conn = null;
        }
        return conn;
    }
    
    public static void processException (SQLException e){
        //generic exception handling so universal error messaging occurs
        System.err.println("Error message: " + e.getMessage());
        System.err.println("Error code: " +  e.getErrorCode());
        System.err.println("SQL state: " + e.getSQLState());
    }
}
