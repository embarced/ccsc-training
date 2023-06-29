package ccsc.refactoring.badtelefon.tarif;

import ccsc.refactoring.badtelefon.Zeitpunkt;

public class Profi extends Tarif {
    @Override
    public double berechneGespraechspreis(int minuten, Zeitpunkt zeitpunkt) {
        return minuten * 0.69;
    }
}
