package ccsc.bowling;

public class Game {
    private int pins = 0;
    private int lastPins = 0;

    public void roll(int fallenPins) {
        this.pins += fallenPins;
    }

    public int score() {
        return this.pins;
    }
}
