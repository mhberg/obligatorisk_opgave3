/**
 * Obligatorisk Opgave 3, 2 SEM
 * @author Mads Heilberg
 */
package jdbcApp.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

/**
 * This class process a recieved ResultSet for display in console.
 */

public class Tours {
    
    public static void displayData(ResultSet rs) throws SQLException{
        //checks for table row count and prints max amount
        rs.last();
        int maxRows = rs.getRow(); //representing max amount of rows
        if (maxRows == 0) {
            System.out.println("NO TOURS FOUND");
        } else {
            System.out.println("Number of tours found: " + maxRows);
            rs.beforeFirst();
        }
        
        //builds + prints all complete table rows represented by Strings
        while(rs.next()){
            StringBuilder builder = new StringBuilder();
            
            builder.append("Tour " + rs.getInt("tourId") + ": ");
            builder.append(rs.getString("tourName"));
            
            double price = rs.getDouble("price");
            String formattedPrice = NumberFormat.getCurrencyInstance().format(price);
            
            builder.append(" (").append(formattedPrice).append(")");
            
            System.out.println(builder.toString());
        }
    }
}
