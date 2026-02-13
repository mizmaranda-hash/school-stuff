import java.util.Random;

// DiceRoll class represents one roll of two six-sided dice
public class DiceRoll {

    // Array to hold the values of two dice
    private final int[] die = new int[2];

    // Sum of the two dice
    private int sum;

    // Random number generator
    private Random randomNumberGenerator;

    // Constructor: automatically rolls two dice
    public DiceRoll() {

        randomNumberGenerator = new Random();

        // nextInt(6) produces 0–5, so +1 makes it 1–6
        die[0] = randomNumberGenerator.nextInt(6) + 1;
        die[1] = randomNumberGenerator.nextInt(6) + 1;

        sum = die[0] + die[1];
    }

    // Returns the total of the two dice
    public int getSum() {
        return sum;
    }

    // Returns a formatted string of the roll
    public String toString() {
        return "Dice: " + die[0] + "  " + die[1] + "  Sum = " + sum;
    }
}

