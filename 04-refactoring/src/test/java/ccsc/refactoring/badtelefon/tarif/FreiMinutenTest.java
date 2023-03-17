package ccsc.refactoring.badtelefon.tarif;

import ccsc.refactoring.badtelefon.tarif.PrivatTarif;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FreiMinutenTest {

    @Test
    void korrekter_abzug_der_freiminute() {
        assertEquals(9, new PrivatTarif().getNettoMinuten(10));
        assertEquals(0, new PrivatTarif().getNettoMinuten(1));
        assertEquals(0, new PrivatTarif().getNettoMinuten(0));
        assertEquals(0, new PrivatTarif().getNettoMinuten(-10));
    }
}
