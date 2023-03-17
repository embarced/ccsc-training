package ccsc.refactoring.badtelefon.tarif;

import ccsc.refactoring.badtelefon.Zeitpunkt;

public abstract class Tarif {


	public static final Tarif PROFI = new Tarif() {
		protected double getPreis(Zeitpunkt zeitpunkt) {
			return 0.69;
		}
	};

	public static Tarif createTarif(TarifArt art) {
		return switch (art) {
			case PRIVAT -> new PrivatTarif();
			case BUSINESS -> new BusinessTarif();
			case PROFI -> PROFI;
		};
	}

	public final double berechneGebuehr(int minuten, Zeitpunkt zeitpunkt) {
		return getNettoMinuten(minuten) * getPreis(zeitpunkt);
	}

	protected abstract double getPreis(Zeitpunkt zeitpunkt);

	protected int getNettoMinuten(int minuten) {
		return minuten;
	}
}
