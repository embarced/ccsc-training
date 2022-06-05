package ccsc.refactoring.badtelefon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZeitpunktTest {

    @Test
    void isMondschein() {
        assertTrue(new Zeitpunkt(20, 30).isMondschein());
        assertTrue(new Zeitpunkt(6, 30).isMondschein());
        assertFalse(new Zeitpunkt(10, 30).isMondschein());
        assertFalse(new Zeitpunkt(9, 00).isMondschein());
        assertFalse(new Zeitpunkt(18, 00).isMondschein());
    }
}