package ccsc.refactoring.badtelefon.tarif;

import ccsc.refactoring.badtelefon.Zeitpunkt;

class Business extends Tarif {
    @Override
    public double berechneGespraechspreis(int minuten, Zeitpunkt zeitpunkt) {
        if (zeitpunkt.isMondscheinZeit())
            return minuten * 0.79;
        else
            return minuten * 1.29;
    }
}
