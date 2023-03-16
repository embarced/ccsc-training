package ccsc.bowling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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
@ExtendWith(MockitoExtension.class)
public class GameTest {

    private Game game;

    @Mock
    private Game mockGame;

    @Test
    void mock_is_able_to_return_perfect_game_score() {
        Mockito.when(mockGame.score()).thenReturn(300);

        assertThat(mockGame.score()).isEqualTo(300);
        assertThat(mockGame.score()).isEqualTo(300);

        Mockito.verify(mockGame, Mockito.times(1)).score();
    }

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
        assertEquals(20, game.score2());
        org.assertj.core.api.Assertions.assertThat(game.score())
                .as("Score ist ..")
                .isEqualTo(20);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void can_roll_all_the_same_numbers(Integer pins) {
        rollManyTimes(20, pins);
        assertThat(game.score()).isGreaterThan(0);
    }

    @ParameterizedTest(name = "{index}: 20 rolls of {0} pin(s) leads to a score of {1}")
    @CsvFileSource(resources = "/pins.csv", numLinesToSkip = 1)
    void can_roll_all_the_same_numbers_again(Integer pins, Integer score) {
        rollManyTimes(20, pins);
        assertThat(game.score()).isEqualTo(score);
    }

    @Test
    void can_roll_a_spare() {
        rollSpare();
        game.roll(5);
        rollManyTimes(17, 0);
        assertEquals(20, game.score());
    }

    private void rollSpare() {
        game.roll(3);
        game.roll(7);
    }
}
