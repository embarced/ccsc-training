package ccsc.refactoring.badtelefon;

import ccsc.refactoring.badtelefon.tarif.Tarif;

public class Kunde {
    private double gebuehr = 0.0;
    private Tarif tarif;

    public Kunde(int tarif) {
        this.tarif = Tarif.createTarif(tarif);
    }

    public void bucheGespraech(int gespraechsdauer, Zeitpunkt zeitpunkt) {
        gebuehr += tarif.berechneGespraechsPreis(gespraechsdauer, zeitpunkt);
    }

    public double getGebuehr() {
        return gebuehr;
    }
}
