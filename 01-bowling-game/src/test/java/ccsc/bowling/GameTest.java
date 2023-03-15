package ccsc.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODOs
 * <p>
 * 1. Test: can roll gutter (no pins at all) ✅
 * 2. Test: can roll One's 20 times ✅
 * 3. Test: Spare
 * 4. Test: Strike
 * 5. Test: Perfect Match
 */
public class GameTest {

    private Game game;

    @BeforeEach
    void createGame() {
        game = new Game();
    }

    @Test
    void can_roll_gutter_game() {
        rollManyTimes(20, 0);
        assertEquals(0, game.score());
    }

    private void rollManyTimes(int rolls, int fallenPins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(fallenPins);
        }
    }

    @Test
    void can_roll_all_ones() {
        rollManyTimes(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    @Disabled
    void can_roll_a_spare() {
        game.roll(3);
        game.roll(7);
        game.roll(5);
        rollManyTimes(17, 0);
        assertEquals(20, game.score());
    }
}
