package ccsc.refactoring.badtelefon;

import ccsc.refactoring.badtelefon.tarif.Tarif;
import ccsc.refactoring.badtelefon.tarif.TarifArt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KundeTest {

    private Kunde privatKunde;
    private Kunde businessKunde;
    private Kunde profiKunde;

    @BeforeEach
    void setUp() {
        privatKunde = new Kunde(TarifArt.PRIVAT);
        businessKunde = new Kunde(TarifArt.BUSINESS);
        profiKunde = new Kunde(TarifArt.PROFI);
    }

    @Test
    void privatTarif() {
        privatKunde.account(5, new Zeitpunkt(5, 30));
        privatKunde.account(15, new Zeitpunkt(16, 30));
        privatKunde.account(5, new Zeitpunkt(21, 30));

        assertEquals(33.379, privatKunde.getGebuehr(), 0.001);
    }

    @Test
    void businessTarif() {
        businessKunde.account(5, new Zeitpunkt(5, 30));
        businessKunde.account(15, new Zeitpunkt(16, 30));
        businessKunde.account(5, new Zeitpunkt(21, 30));

        assertEquals(27.25, businessKunde.getGebuehr(), 0.001);
    }

    @Test
    void profiTarif() {
        profiKunde.account(5, new Zeitpunkt(5, 30));
        profiKunde.account(15, new Zeitpunkt(16, 30));
        profiKunde.account(5, new Zeitpunkt(21, 30));

        assertEquals(17.25, profiKunde.getGebuehr(), 0.001);
    }

}
