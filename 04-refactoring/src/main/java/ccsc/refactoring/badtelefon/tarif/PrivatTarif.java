package ccsc.refactoring.badtelefon.tarif;

import ccsc.refactoring.badtelefon.Zeitpunkt;

public class PrivatTarif extends Tarif {

    public static final double MONDSCHEINPREISMINUTENPREIS = 0.69;
    public static final int FREIMINUTE = 1;

    @Override
    protected int getNettoMinuten(int minuten) {
        minuten = minuten - FREIMINUTE;
        return minuten < 0 ? 0 : minuten;
    }

    @Override
    protected double getPreis(Zeitpunkt zeitpunkt) {
        return zeitpunkt.isMondschein() ? MONDSCHEINPREISMINUTENPREIS : 1.99;
    }
}
