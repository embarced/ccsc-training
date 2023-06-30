package ccsc.refactoring.badtelefon.tarif;

import ccsc.refactoring.badtelefon.Zeitpunkt;

public enum TarifTyp {
    PRIVAT {
        @Override
        public double berechneGespraechspreis(int minuten, Zeitpunkt zeitpunkt) {
            minuten = minuten - 1;
            minuten = minuten < 0 ? 0 : minuten;
            if (zeitpunkt.isMondscheinZeit())
                return minuten * 0.69;
            else
                return minuten * 1.99;
        }
    }, BUSINESS {
        @Override
        public double berechneGespraechspreis(int minuten, Zeitpunkt zeitpunkt) {
            if (zeitpunkt.isMondscheinZeit())
                return minuten * 0.79;
            else
                return minuten * 1.29;
        }
    }, PROFI {
        @Override
        public double berechneGespraechspreis(int minuten, Zeitpunkt zeitpunkt) {
            return minuten * 0.69;
        }
    };

    public abstract double berechneGespraechspreis(int minuten, Zeitpunkt zeitpunkt);

}
