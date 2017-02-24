/**
 * Obligatorisk Opgave 3, 2 SEM
 * @author Mads Heilberg
 */
package randomWalk;

/**
 * This class simulates two particles moving in space and counts collisions.
 */
public class Collisions {

    public static void main(String[] args) {
        int limit = 2000000; //movement boundary
        int maxSteps = 100000; //max steps allowed
        int colCount = 0; //represents collision amounts

    //step 9 - create particles to walk, also added x,y getters in RandomWalk
        RandomWalk p1 = new RandomWalk(maxSteps, limit, -3, 0);
        RandomWalk p2 = new RandomWalk(maxSteps, limit, 0, 3);

        //this loop takeStep() the particles and check for shared position
        do {
            if (Collisions.samePosition(p1, p2)) {
                colCount++;
            }
            p1.takeStep();
            p2.takeStep();
        } while (p1.moreSteps() && p2.moreSteps());

        System.out.println("Collisions made: " + colCount);
    }
    
    //step 10
    public static boolean samePosition(RandomWalk p1, RandomWalk p2) {
        //returns true if x,y positions of 2 RandomWalk objects are shared
        return p1.getX() == p2.getX() && p1.getY() == p2.getY();
    }
}
