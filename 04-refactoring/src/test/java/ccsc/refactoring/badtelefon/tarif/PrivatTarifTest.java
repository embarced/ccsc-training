package ccsc.refactoring.badtelefon.tarif;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrivatTarifTest {

    @Test
    void berechneNettoDauer(){
        assertEquals(10, new PrivatTarif().getNettoDauer(11));
        assertEquals(0, new PrivatTarif().getNettoDauer(1));
        assertEquals(0, new PrivatTarif().getNettoDauer(0));
    }
}