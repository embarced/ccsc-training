package ccsc.refactoring.badtelefon.tarif;

import ccsc.refactoring.badtelefon.Zeitpunkt;

public abstract class Tarif {
	public final static int PRIVAT = 0;
	public final static int BUSINESS = 1;
	public final static int PROFI = 2;

	int tarif = 0;

	private Tarif derTarif;

	protected Tarif() {
	}

	public Tarif(int tarif) {
		this.tarif = tarif;

		this.derTarif = instanceOf(tarif);
	}

	public static Tarif instanceOf(int tarif) {
		switch (tarif) {
			case PRIVAT:
				return new Privat();
			case BUSINESS:
				return new Business();
			case PROFI:
				return new Profi();
			default:
				throw new IllegalArgumentException(String.format("Tarifart %s ist ungültig", tarif));
		}
	}

	public abstract double berechneGespraechspreis(int minuten, Zeitpunkt zeitpunkt);
}
