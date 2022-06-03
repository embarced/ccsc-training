package ccsc.refactoring.badtelefon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZeitpunktTest {

    Zeitpunkt zeitpunkt;

    @BeforeEach
    void setUp() {
        this.zeitpunkt = new Zeitpunkt(10, 30);
    }

    @Test
    void can_create_a_Zeitpunkt() {
        assertNotNull(zeitpunkt);
    }

    @Test
    void isMondschein() {
        Zeitpunkt zeitpunkt1 = new Zeitpunkt(6, 0);
        Assertions.assertThat(zeitpunkt1.isMondschein()).isTrue();
    }

    @Test
    void isNotMondschein() {
        Zeitpunkt zeitpunkt = new Zeitpunkt(12, 0);
        Assertions.assertThat(zeitpunkt.isMondschein()).isFalse();
    }

    @Test
    void is_Mondschein_Grenzfall() {
        Zeitpunkt zeitpunkt = new Zeitpunkt(18, 0);
        Assertions.assertThat(zeitpunkt.isMondschein()).isFalse();
    }
}