package ccsc.refactoring.badtelefon.tarif;

import ccsc.refactoring.badtelefon.Zeitpunkt;

public class BusinessTarif extends Tarif {
    public BusinessTarif() {
        super(Tarif.BUSINESS);
    }

    @Override
    public double berechneGebuehr(int minuten, Zeitpunkt zeitpunkt) {
        if (zeitpunkt.isMondschein()) {
            return minuten * 0.79;
        } else {
            return minuten * 1.29;
        }
    }
}
