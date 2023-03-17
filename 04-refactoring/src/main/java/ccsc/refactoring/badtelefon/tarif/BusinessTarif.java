package ccsc.refactoring.badtelefon.tarif;

import ccsc.refactoring.badtelefon.Zeitpunkt;

public class BusinessTarif extends Tarif {
    @Override
    protected double getPreis(Zeitpunkt zeitpunkt) {
        return zeitpunkt.isMondschein() ? 0.79 : 1.29;
    }
}
