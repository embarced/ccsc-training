package ccsc.refactoring.badtelefon.tarif;

import ccsc.refactoring.badtelefon.Zeitpunkt;

public abstract class Tarif {
	public final static int PRIVAT = 0;
	public final static int BUSINESS = 1;
	public final static int PROFI = 2;

	private int tarif = 0;

	public static Tarif createTarif(int tarifArt) {
		switch(tarifArt) {
			case PRIVAT: return new PrivatTarif();
			case BUSINESS: return new BusinessTarif();
			case PROFI: return new ProfiTarif();
		}
		throw new IllegalArgumentException(String.format("Ungültige Tarifklasse: %s", tarifArt));
	}

	public final double berechneGespraechsPreis(int gespraechsdauer, Zeitpunkt zeitpunkt) {
		return getNettoDauer(gespraechsdauer) * getPreisProMinute(zeitpunkt);
	}

	protected abstract double getPreisProMinute(Zeitpunkt zeitpunkt);

	protected int getNettoDauer(int gespraechsdauer) {
		return gespraechsdauer;
	}
}
