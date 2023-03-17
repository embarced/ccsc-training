package ccsc.refactoring.badtelefon.tarif;

import ccsc.refactoring.badtelefon.Zeitpunkt;

public class ProfiTarif extends Tarif {

    @Override
    protected double getPreis(Zeitpunkt zeitpunkt) {
        return 0.69;
    }
}
