package ccsc.refactoring.badtelefon.tarif;

import ccsc.refactoring.badtelefon.tarif.TarifTyp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FreiminutenTest {
    @Test
    void ziehe_freiminute_ab() {
        assertEquals(4, TarifTyp.PRIVAT.getNettoMinuten(5));
    }

    @Test
    void darf_nicht_negativ_werden() {
        assertEquals(0, TarifTyp.PRIVAT.getNettoMinuten(0));
    }
    @Test
    void brutto_gleich_netto() {
        assertEquals(10, TarifTyp.PROFI.getNettoMinuten(10));
        assertEquals(10, TarifTyp.BUSINESS.getNettoMinuten(10));
    }


}
