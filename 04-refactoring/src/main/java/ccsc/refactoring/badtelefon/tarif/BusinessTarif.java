package ccsc.refactoring.badtelefon.tarif;

import ccsc.refactoring.badtelefon.Zeitpunkt;

public class BusinessTarif extends Tarif {

    protected double getPreisProMinute(Zeitpunkt zeitpunkt) {
        if (zeitpunkt.isMondschein()) {
            return 0.79;
        } else {
            return 1.29;
        }
    }
}
