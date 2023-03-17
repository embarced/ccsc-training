package ccsc.refactoring.badtelefon.tarif;

import ccsc.refactoring.badtelefon.Zeitpunkt;

public abstract class Tarif {
	public final double berechneGebuehr(int minuten, Zeitpunkt zeitpunkt) {
		return getNettoMinuten(minuten) * getPreis(zeitpunkt);
	}

	protected abstract double getPreis(Zeitpunkt zeitpunkt);

	protected int getNettoMinuten(int minuten) {
		return minuten;
	}
}
