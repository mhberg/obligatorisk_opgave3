/**
 * Obligatorisk Opgave 3, 2 SEM
 * @author Mads Heilberg
 */
package randomWalk;

/**
 * This class represents a random walk, defining it's behavior.
 */
public class RandomWalk {
    //step 1 (also see toString)
    private int x, y; //variables representing x & y coordinates
    private int steps; //representing steps taken
    private final int MAX_STEPS; //representing max steps allowed
    private final int LIMIT; //representing the boundary square of allowed movement

    //step 11.a
    private int maxDistance;
    private final int START_X; //x origin position, see step 11.c
    private final int START_Y; //y origin position, see step 11.c

    public RandomWalk(int max, int edge) {
        MAX_STEPS = max;
        LIMIT = edge;
        x = 0;
        y = 0;
        START_X = x;
        START_Y = y;
        steps = 0;
        maxDistance = 0;
    }

    public RandomWalk(int max, int edge, int startX, int startY) {
        MAX_STEPS = max;
        LIMIT = edge;
        x = startX;
        y = startY;
        START_X = x;
        START_Y = y;
        steps = 0;
        maxDistance = 0;
    }

    //step 11.b
    private int max(int num1, int num2) {
        int max; //representing the largest integer
        
        if (num1 > num2) {
            max = num1;
        } else {
            max = num2; //note: if same size, num2 == num1
        }        
        return max;
    }

    //step 3
    public void takeStep() {
        //a random number is generated to represent a step taken, on one axis.
        switch ((int) (Math.random() * 4)) {
            case 0: x++; break;
            case 1: x--; break;
            case 2: y++; break;
            case 3: y--; break;
            default: System.out.println("HACKERMAN"); break;
        }
        steps++;
        
    //step 11.c
    /**
     * While technically it was possible to write this in one statement, it was
     * not too readable. I added 2 final variables to hold the starting point
     * for each position to calculate current distance to origin, as the start
     * point is not always 0.
     */
        int currentDistanceX = Math.abs(x - START_X);
        int currentDistanceY = Math.abs(y - START_Y);
        
        //finds the largest distance candidate for each step
        int largestDistance = this.max(currentDistanceX, currentDistanceY);
        
        //checks and stores new largest distance so far, if larger than old
        maxDistance = this.max(this.maxDistance, largestDistance);
    }

    //step 5
    public boolean moreSteps() {
        //returns true if steps is lesser than maxSteps
        return steps < MAX_STEPS;
    }

    public boolean inBounds() {
        //returns true if x and y is within the boundary square
        return (x < LIMIT && x > -LIMIT) && (y < LIMIT && y > -LIMIT);
    }

    //step 6
    public void walk() {
        //execute walk as long as steps != maxSteps and position is within limit
        while (this.moreSteps() && this.inBounds()) {
            this.takeStep();
        }
    }

    @Override
    public String toString() {
        return "Steps: " + steps + "; Position: " + "(" + x + "," + y + ")";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    //step 11.d
    public int getMaxDistance() {
        return maxDistance;
    }
    
    
}
