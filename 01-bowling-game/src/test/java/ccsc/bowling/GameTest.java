package ccsc.bowling;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * TODOs
 * <p>
 * 1. Test: can roll gutter (no pins at all) (/)
 * 2. Test: can roll One's 20 times (/)
 * 3. Test: Spare (/)
 * 4. Test: Strike (/)
 * 5. Test: Perfect Match (/)
 */
@Tags({@Tag("unit"), @Tag("game")})
@ExtendWith(MockitoExtension.class)
class GameTest {

    private Game game;

    @Mock
    private Game mockGame;

    @Test
    void mock_is_able_to_return_perfect_game_score() {
        Mockito.when(mockGame.getScore()).thenReturn(300);
        assertThat(mockGame.getScore()).isEqualTo(300);
        assertThat(mockGame.getScore()).isEqualTo(300);

        Mockito.verify(mockGame, Mockito.times(2)).getScore();
    }

    @BeforeEach
    void setup() {
        game = new Game();
        System.out.println("setup() was called");
    }

    @BeforeAll
    static void setupOnce() {
        System.out.println("setupOnce() was called");
    }

    @AfterEach
    void cleanup() {
        System.out.println("cleanup() was called");
    }

    @AfterAll
    static void cleanupOnce() {
        System.out.println("cleanupOnce() was called");
    }

    @Test
    @DisplayName("rolls only zero pins")
    void can_roll_gutter_game() {
        rollMany(20, 0);
        assertEquals(0, game.getScore());
    }

    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }

    @Test
    void can_roll_all_ones() {
        rollMany(20, 1);
        assertThat(game.getScore())
                .as("Game with %s rolls of %s pin(s)", 20, 1)
                .isEqualTo(20);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void can_roll_all_the_same_numbers(Integer pins) {
        rollMany(20, pins);
        assertThat(game.getScore()).isGreaterThan(0);
    }

    @ParameterizedTest(name = "{index}: 20 rolls of {0} pin(s) leads to a score of {1}")
    @CsvFileSource(resources = "/pins.csv", numLinesToSkip = 1)
    void can_roll_all_the_same_numbers_again(Integer pins, Integer score) {
        rollMany(20, pins);
        assertThat(game.getScore()).isEqualTo(score);
    }

    @Test
    void can_roll_one_spare() {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.getScore());
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    @Test
    void can_roll_one_strike() {
        rollStrike();
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        assertEquals(24, game.getScore());
    }

    private void rollStrike() {
        game.roll(10);
    }

    @Test
    void can_play_perfect_game() {
        rollMany(12, 10);
        assertEquals(300, game.getScore());
    }

    @Test
    void exception_should_be_thrown() {
        assertThatThrownBy(() -> {
            List<Integer> list = Arrays.asList(1, 2);
            list.get(100);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index 100 out of bounds for length 2");
    }
}