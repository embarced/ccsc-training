package ccsc.refactoring.badtelefon;

<<<<<<< HEAD
import org.assertj.core.api.Assertions;
=======
>>>>>>> temp
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZeitpunktTest {

    private Zeitpunkt zeitpunkt;

    @BeforeEach
    void setUp() {
        zeitpunkt = new Zeitpunkt(10, 30);
    }

    @Test
    void kann_Zeitpunkt_erzeugen() {
        assertNotNull(zeitpunkt);
        assertEquals(10, zeitpunkt.getStunde());
    }

    @Test
    void isMondschein() {
        assertTrue(new Zeitpunkt(8, 0).isMondschein());
        assertFalse(new Zeitpunkt(10, 0).isMondschein());
        assertFalse(new Zeitpunkt(18, 0).isMondschein());
    }
}