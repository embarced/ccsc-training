package ccsc.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODOs
 *
 * 1. Test: can roll gutter (no pins at all) (/)
 * 2. Test: can roll One's 20 times (/)✅
 * 3. Test: Spare
 * 4. Test: Strike
 * 5. Test: Perfect Match
 */
class GameTest {

    private Game game;

    @BeforeEach
    void setup() {
        game = new Game();
    }

    @Test
    void can_roll_gutter_game() {
        rollMany(0, 20);
        assertEquals(0, game.getScore());
    }

    @Test
    void can_roll_all_ones() {
        rollMany(1, 20);
        assertEquals(20, game.getScore());
    }

    private void rollMany(int pins, int rolls) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }
}