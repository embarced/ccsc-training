package ccsc.refactoring.badtelefon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KundeTest {

    private Kunde privatKunde;
    private Kunde businessKunde;
    private Kunde profiKunde;

    @BeforeEach
    void setUp() {
        privatKunde = new Kunde(Tarif.PRIVAT);
        businessKunde = new Kunde(Tarif.BUSINESS);
        profiKunde = new Kunde(Tarif.PROFI);
    }

    @Test
    void privatTarif() {
        privatKunde.account(5, 5, 30);
        privatKunde.account(15, 16, 30);
        privatKunde.account(5, 21, 30);

        assertEquals(33.379, privatKunde.getGebuehr(), 0.001);
    }

    @Test
    void businessTarif() {
        businessKunde.account(5, 5, 30);
        businessKunde.account(15, 16, 30);
        businessKunde.account(5, 21, 30);

        assertEquals(27.25, businessKunde.getGebuehr(), 0.001);
    }

    @Test
    void profiTarif() {
        profiKunde.account(5, 5, 30);
        profiKunde.account(15, 16, 30);
        profiKunde.account(5, 21, 30);

        assertEquals(17.25, profiKunde.getGebuehr(), 0.001);
    }

}
