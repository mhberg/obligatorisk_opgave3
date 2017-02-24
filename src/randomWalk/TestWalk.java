/**
 * Obligatorisk Opgave 3, 2 SEM
 * @author Mads Heilberg
 */
package randomWalk;

import java.util.Scanner;

/**
 * This class is used to test RandomWalk behavior. It follows the Lab exercise
 * description, I have included step numbers as comments.
 */
public class TestWalk {

    public static void main(String[] args) {
        int x, y;        //starting x & y coordinates
        int maxSteps;   //maxmimum number of steps in a walk
        int limit;   //maxmimum x & y coordinate
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\nRandom Walk Test Program");
        System.out.println();
        
        System.out.print("Enter the boundary for the square: ");
        limit = scan.nextInt();
        
        System.out.print("Enter the maximum number of steps: ");
        maxSteps = scan.nextInt();
        
        System.out.println("Enter the starting x and y coordinates with " +
                "a space between: ");
        x = scan.nextInt();
        y = scan.nextInt();
        
        //step 2 - instantiating RandomWalk objects and testing
        RandomWalk rw1 = new RandomWalk(10, 5);
        RandomWalk rw2 = new RandomWalk(maxSteps, limit, x, y);
        
        System.out.println("[Walk 1] " + rw1 + " | " + "[Walk 2] " + rw2);
        System.out.println("-------------------------------------");
        
        //step 4 - test loop for takeStep() method
        for (int i = 0; i < 5; i++) {
            rw1.takeStep();
            rw2.takeStep();
            System.out.println("[Walk 1] " + rw1 + " | " + "[Walk 2] " + rw2);
        }    
        System.out.println("-------------------------------------");
        
        //step 11.e - testing maxDistance
        System.out.println("[Walk 1] maxDistance: " + rw1.getMaxDistance() + "\n" +
                "[Walk 2] maxDistance: " + rw2.getMaxDistance());
        System.out.println("-------------------------------------");
        
        //step 7 - testing walk() method
        RandomWalk rw3 = new RandomWalk(200, 10, 0, 0);
        rw3.walk();
        System.out.println("[Walk 3] " + rw3);    
    }

}
