package ccsc.refactoring.badtelefon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ZeitpunktTest {

    @Test
    void ist_mondschein_zeit(){
        assertTrue(new Zeitpunkt(7, 30).isMondscheinZeit());
        assertTrue(new Zeitpunkt(20, 30).isMondscheinZeit());
        assertTrue(new Zeitpunkt(19, 30).isMondscheinZeit());
    }
    @Test
    void ist_nicht_mondschein_zeit(){
        assertFalse(new Zeitpunkt(9, 30).isMondscheinZeit());
        assertFalse(new Zeitpunkt(12, 30).isMondscheinZeit());
        assertFalse(new Zeitpunkt(18, 30).isMondscheinZeit());
    }
}
