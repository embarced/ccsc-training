package ccsc.bowling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODOs
 *
 * 1. Test: can roll gutter (no pins at all) (/)
 * 2. Test: can roll One's 20 times
 * 3. Test: Spare
 * 4. Test: Strike
 * 5. Test: Perfect Match
 */
class GameTest {

    @Test
    void can_roll_gutter_game() {
        Game game = new Game();
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        Assertions.assertEquals(0, game.getScore());
    }

}