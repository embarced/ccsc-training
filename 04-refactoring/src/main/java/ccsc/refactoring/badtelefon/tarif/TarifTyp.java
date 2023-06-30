package ccsc.refactoring.badtelefon.tarif;

import ccsc.refactoring.badtelefon.Zeitpunkt;

public enum TarifTyp {
    PRIVAT {
        @Override
        protected double getMinutenPreis(Zeitpunkt zeitpunkt) {
            return zeitpunkt.isMondscheinZeit() ? 0.69 : 1.99;
        }

        @Override
        protected int getNettoMinuten(int minuten) {
            minuten = minuten - 1;
            return minuten < 0 ? 0 : minuten;
        }

    }, BUSINESS {
        @Override
        protected double getMinutenPreis(Zeitpunkt zeitpunkt) {
            return zeitpunkt.isMondscheinZeit() ? 0.79 : 1.29;
        }
    }, PROFI {
        @Override
        protected double getMinutenPreis(Zeitpunkt zeitpunkt) {
            return 0.69;
        }
    };

    public double berechneGespraechspreis(int minuten, Zeitpunkt zeitpunkt) {
        return getNettoMinuten(minuten) * getMinutenPreis(zeitpunkt);
    }

    protected int getNettoMinuten(int bruttoMinuten) {
        return bruttoMinuten;
    }

    protected abstract double getMinutenPreis(Zeitpunkt zeitpunkt);

}
