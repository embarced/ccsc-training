package ccsc.refactoring.badtelefon.tarif;

import ccsc.refactoring.badtelefon.Zeitpunkt;

public abstract class Tarif {
	public final static int PRIVAT = 0;
	public final static int BUSINESS = 1;
	public final static int PROFI = 2;

	int tarif = 0;

	public final double berechneGebuehr(int minuten, Zeitpunkt zeitpunkt) {
		// minuten * preis
		return getNettoMinuten(minuten) * getPreis(zeitpunkt);
	}

	protected abstract double getPreis(Zeitpunkt zeitpunkt);

	protected int getNettoMinuten(int minuten) {
		return minuten;
	}
}
