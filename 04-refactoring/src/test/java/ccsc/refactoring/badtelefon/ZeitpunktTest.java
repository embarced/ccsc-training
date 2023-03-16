package ccsc.refactoring.badtelefon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ZeitpunktTest {

    @Test
    void testIsMondschein() {
        assertTrue(new Zeitpunkt(19, 0).isMondschein());
        assertFalse(new Zeitpunkt(12, 0).isMondschein());
        assertTrue(new Zeitpunkt(8, 59).isMondschein());
        assertFalse(new Zeitpunkt(9,0).isMondschein());
        assertFalse(new Zeitpunkt(18,59).isMondschein());
    }
}
