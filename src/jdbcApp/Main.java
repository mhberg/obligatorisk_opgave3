/**
 * Obligatorisk Opgave 3, 2 SEM
 * @author Mads Heilberg
 */
package jdbcApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import jdbcApp.tables.Tours;
import jdbcApp.util.InputHelper;

/**
 * This class prompts the user for database choice and runs connection + query.
 */

public class Main {

    private static final String SQL = "SELECT * FROM tours WHERE price <= ?";

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in); //scanner for user input
        DBType dbType = null; //placeholder for enum identifier choice
        String input; //input for menu
        double maxPrice = 0; //start instantiation for max price prompt

        System.out.print("Choose a database to see available tours "
                + "(Type 1 for MySQL OR 2 for HyperSQL OR exit to quit): ");
        //menu loop until database or System.exit is chosen
        while (dbType == null) {
            input = scan.nextLine().toLowerCase();
            switch(input){
                case "1": dbType = DBType.MYSQL_DB; System.out.println("[MySQL]"); break;
                case "2": dbType = DBType.HSQL_DB; System.out.println("[HyperSQL]"); break;
                case "exit": System.exit(0);
                default: System.out.println("Invalid input, try again!"); break;
            }
        }
        
        //prompts for price input and handles NumberFormatException
        try {
            maxPrice = InputHelper.getDoubleInput("Enter a maximum price: ");
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid number");
        }

        //defined outside try with ressources block to execute the PrepStatement
        ResultSet rs = null;

        //gets a connection, prepares a statement and calls displayData to show
        try (
                Connection conn = DBUtil.getConnection(dbType);
                PreparedStatement stmt = conn.prepareStatement(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);){
            stmt.setDouble(1, maxPrice); //sets the dynamic sql input
            rs = stmt.executeQuery(); //executed after the dymamic input is set
            Tours.displayData(rs);
        } catch (SQLException e) {
            DBUtil.processException(e);
        } finally {
            //closes the ResultSet as it is defined outside try with ressources
            if (rs != null) {
                rs.close();
            }
        }
    }
}

