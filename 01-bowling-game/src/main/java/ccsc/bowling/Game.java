package ccsc.bowling;

public class Game {

    private int rolls[] = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int getScore() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
                score += 10 + strikeBonus(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex + 2);
                frameIndex += 2;
            } else {
                score += sumOfBallsInFrame(rolls[frameIndex], rolls[frameIndex + 1]);
                frameIndex += 2;
            }
        }
        return score;
    }

    private int sumOfBallsInFrame(int rolls, int rolls1) {
        return rolls + rolls1;
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex];
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }
    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }
}
