package ccsc.refactoring.badtelefon.tarif;

import ccsc.refactoring.badtelefon.Zeitpunkt;

public class PrivatTarif extends Tarif {

    @Override
    protected double getPreisProMinute(Zeitpunkt zeitpunkt) {
        if (zeitpunkt.isMondschein())
            return 0.69;
        else
            return 1.99;
    }
    protected int getNettoDauer(int gespraechsdauer) {
        return Math.max(0, gespraechsdauer - 1);
    }
}
