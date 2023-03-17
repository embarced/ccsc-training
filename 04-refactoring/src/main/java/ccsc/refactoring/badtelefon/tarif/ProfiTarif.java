package ccsc.refactoring.badtelefon.tarif;

import ccsc.refactoring.badtelefon.Zeitpunkt;

public class ProfiTarif extends Tarif {
    public ProfiTarif() {
        super(Tarif.PROFI);
    }

    @Override
    public double berechneGebuehr(int minuten, Zeitpunkt zeitpunkt) {
        return minuten * 0.69;
    }
}
