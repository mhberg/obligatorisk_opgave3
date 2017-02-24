/**
 * Obligatorisk Opgave 3, 2 SEM
 * @author Mads Heilberg
 */
package randomWalk;

/**
 * This class simulates a drunken walk using RandomWalk.
 */
public class DrunkenWalk {

    public static void main(String[] args) {
        int drunkCount = 100; //simulated number of drunks
        int fallCount = 0; //out-of-bounds count
        int limit = 50; //movement boundary
        int maxSteps = 200; //max steps allowed

    //step 8 - loop for counting out-of-bounds walks
        for (int i = 0; i < drunkCount; i++) {
            RandomWalk rw = new RandomWalk(maxSteps, limit);
            rw.walk();
            if (!rw.inBounds()) {
                fallCount++;
            }
        }

        //Damage report - manipulate limit & maxSteps for different results
        if (fallCount == 0) {
            System.out.println("Everyone survived! :D");
        } else if (fallCount == drunkCount) {
            System.out.println("Everyone died.. RIP :(");
        } else {
            System.out.println("Survivors: " + (drunkCount - fallCount) + "\n" + 
                    "Drunks out-of-bounds: " + fallCount);
        }
    }
}
