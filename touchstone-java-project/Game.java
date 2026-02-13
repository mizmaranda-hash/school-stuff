import java.time.LocalDateTime;
import java.util.ArrayList;

// Game class handles the logic of one full Craps game
public class Game {

    private String playerName = "";
    private LocalDateTime gameDateTime;

    // Stores each dice roll
    private ArrayList<DiceRoll> diceRolls;

    private int point = 0;
    private boolean keepRolling = true;

    private String gameResult = "";

    // Constructor initializes player and game time
    public Game(String playerName) {
        gameDateTime = LocalDateTime.now();
        this.playerName = playerName;
        diceRolls = new ArrayList<>();
    }

    // Plays one game of Craps
    public ArrayList<DiceRoll> play() {

        DiceRoll roll = new DiceRoll();
        diceRolls.add(roll);

        int sum = roll.getSum();

        // Immediate loss conditions
        if (sum == 2 || sum == 3 || sum == 12) {
            gameResult = "Lose";
            keepRolling = false;
        }

        // Immediate win conditions
        else if (sum == 7 || sum == 11) {
            gameResult = "Win";
            keepRolling = false;
        }

        else {
            // Set the point
            point = sum;
        }

        // Continue rolling if game not finished
        while (keepRolling) {

            roll = new DiceRoll();
            diceRolls.add(roll);

            if (roll.getSum() == 7) {
                gameResult = "Lose";
                keepRolling = false;
            }

            else if (roll.getSum() == point) {
                gameResult = "Win";
                keepRolling = false;
            }
        }

        return diceRolls;
    }

    public String getResult() {
        return gameResult;
    }

    public int getRollCount() {
        return diceRolls.size();
    }

    public String getPlayerName() {
        return playerName;
    }

    public LocalDateTime getGameDateTime() {
        return gameDateTime;
    }
}

