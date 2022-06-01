package ccsc.bowling;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODOs
 * <p>
 * 1. Test: can roll gutter (no pins at all) ✔
 * 2. Test: can roll One's 20 times ✔️
 * 3. Test: Spare ✔️
 * 4. Test: Strike
 * 5. Test: Perfect Match
 * 6. rename parameter i in roll()
 */
public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void can_roll_gutter() {
        // given

        // when
        rollMany(20, 0);

        // then
        assertEquals(0, game.getScore(), "Score should be zero when rolling only zeros");
    }

    @Test
    void can_roll_all_ones() {
        rollMany(20, 1);
        assertEquals(20, game.getScore());
        Assertions.assertThat(game.getScore()).isEqualTo(21);
    }

    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }

    @Test
    void can_roll_spare() {
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollMany(17,0);
        assertEquals(16, game.getScore());
    }

}
