package ccsc.bowling;

public class Game {
    private final int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int getScore() {
        int score = 0;
        for (int frame = 0, current = 0; frame < 10; frame++, current += 2) {
            if (rolls[current] + rolls[current + 1] == 10) { // spare
                score += 10 + rolls[current + 2];
            } else {
                score += rolls[current] + rolls[current + 1];
            }
        }
        return score;
    }
}
