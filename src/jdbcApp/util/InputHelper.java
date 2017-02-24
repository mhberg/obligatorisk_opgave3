/**
 * Obligatorisk Opgave 3, 2 SEM
 * @author Mads Heilberg
 */
package jdbcApp.util;
    
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class handles a prompt for input and processes that input.
 */

public class InputHelper {
    
    private static String getInput(String prompt){
        //promps for input and returns said input while handling IOExceptions
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        
        System.out.print(prompt);
        System.out.flush();
        
        try {
            input = reader.readLine();
            reader.close();
        } catch (IOException e){
            input = "Error: " + e.getMessage();
        }
        return input;
    }
    
    public static double getDoubleInput(String prompt) throws NumberFormatException {
        //processes the input from getInput by parsing to double (see Main)
        return Double.parseDouble(getInput(prompt));
    }
}
