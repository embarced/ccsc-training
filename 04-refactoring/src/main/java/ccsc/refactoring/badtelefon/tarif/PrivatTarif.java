package ccsc.refactoring.badtelefon.tarif;

import ccsc.refactoring.badtelefon.Zeitpunkt;

public class PrivatTarif extends Tarif {
    public PrivatTarif() {
        super(Tarif.PRIVAT);
    }

    @Override
    public double berechneGebuehr(int minuten, Zeitpunkt zeitpunkt) {
        minuten = minuten - 1;
        minuten = minuten < 0 ? 0 : minuten;
        if (zeitpunkt.isMondschein()) {
            return minuten * 0.69;
        } else {
            return minuten * 1.99;
        }
    }
}
