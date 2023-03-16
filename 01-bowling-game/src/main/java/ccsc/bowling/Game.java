package ccsc.bowling;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Game {
    private int pins = 0;
    private int rolls[] = new int[21];
    private short currentRoll = 0;

    public void roll(int fallenPins) {
        this.pins += fallenPins;
        rolls[currentRoll] = fallenPins;
        currentRoll++;
    }

    public int score() {
        int score = 0;
        int i = 0;
        for (int frame = 0; frame < 10; frame++) {
            boolean isSpare = rolls[i] + rolls[i + 1] == 10;
            if (isSpare) {
                score += 10 + rolls[i + 2];
            } else {
                score += rolls[i] + rolls[i + 1];
            }
            i += 2;
        }
        return score;
    }

    public int score2() {
        return IntStream.of(rolls).reduce(0, (all, el) -> all + el);
    }
}
