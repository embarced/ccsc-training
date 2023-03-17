package ccsc.refactoring.badtelefon.tarif;

import ccsc.refactoring.badtelefon.Zeitpunkt;

public enum TarifArt {
    PRIVAT(("Privattarif")) {
        @Override
        protected int getNettoMinuten(int minuten) {
            return Math.max(minuten - 1, 0);
        }

        @Override
        protected double getPreis(Zeitpunkt zeitpunkt) {
            return zeitpunkt.isMondschein() ? 0.69 : 1.99;
        }
    }, BUSINESS("Businesstarif") {
        @Override
        protected double getPreis(Zeitpunkt zeitpunkt) {
            return zeitpunkt.isMondschein() ? 0.79 : 1.29;
        }
    }, PROFI("Profitarif") {
        @Override
        protected double getPreis(Zeitpunkt zeitpunkt) {
            return 0.69;
        }
    };

    private String name;

    TarifArt(String name) {
        this.name = name;
    }

    public final double berechneGebuehr(int minuten, Zeitpunkt zeitpunkt) {
        System.out.println("Ich nutze TarifArt");
        return getNettoMinuten(minuten) * getPreis(zeitpunkt);
    }

    protected abstract double getPreis(Zeitpunkt zeitpunkt);

    protected int getNettoMinuten(int minuten) {
        return minuten;
    }
}
