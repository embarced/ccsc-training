package ccsc.refactoring.badtelefon;

import ccsc.refactoring.badtelefon.tarif.PrivatTarif;
import ccsc.refactoring.badtelefon.tarif.Tarif;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TarifTest {

    private Tarif tarif;

    @BeforeEach
    void setUp() {
        tarif = Tarif.createTarif(Tarif.PRIVAT);
    }

    @Test
    void berechneGespraechsPreis() {
        assertEquals(17.91, tarif.berechneGespraechsPreis(10, new Zeitpunkt(10, 30)));
    }

    @Test
    void createPrivatTarif() {
        assertEquals(PrivatTarif.class, Tarif.createTarif(Tarif.PRIVAT).getClass());
    }
}