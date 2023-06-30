package ccsc.refactoring.badtelefon;

import ccsc.refactoring.badtelefon.tarif.Tarif;
import ccsc.refactoring.badtelefon.tarif.TarifTyp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KundeTest {

    private Kunde privatKunde;
    private Kunde businessKunde;
    private Kunde profiKunde;

    @BeforeEach
    void setUp() {
        privatKunde = new Kunde(TarifTyp.PRIVAT);
        businessKunde = new Kunde(TarifTyp.BUSINESS);
        profiKunde = new Kunde(TarifTyp.PROFI);
    }

    @Test
    void privatTarif() {
        privatKunde.bucheGespraech(5, new Zeitpunkt(5, 30));
        privatKunde.bucheGespraech(15, new Zeitpunkt(16, 30));
        privatKunde.bucheGespraech(5, new Zeitpunkt(21, 30));

        assertEquals(33.379, privatKunde.getGebuehr(), 0.001);
    }

    @Test
    void businessTarif() {
        businessKunde.bucheGespraech(5, new Zeitpunkt(5, 30));
        businessKunde.bucheGespraech(15, new Zeitpunkt(16, 30));
        businessKunde.bucheGespraech(5, new Zeitpunkt(21, 30));

        assertEquals(27.25, businessKunde.getGebuehr(), 0.001);
    }

    @Test
    void profiTarif() {
        profiKunde.bucheGespraech(5, new Zeitpunkt(5, 30));
        profiKunde.bucheGespraech(15, new Zeitpunkt(16, 30));
        profiKunde.bucheGespraech(5, new Zeitpunkt(21, 30));

        assertEquals(17.25, profiKunde.getGebuehr(), 0.001);
    }

}
