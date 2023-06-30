package ccsc.refactoring.badtelefon.tarif;

import ccsc.refactoring.badtelefon.Zeitpunkt;

public abstract class Tarif {
	private static final Tarif PRIVAT =

			new Tarif() {
		@Override
		public double berechneGespraechspreis(int minuten, Zeitpunkt zeitpunkt) {
			minuten = minuten - 1;
			minuten = minuten < 0 ? 0 : minuten;
			if (zeitpunkt.isMondscheinZeit())
				return minuten * 0.69;
			else
				return minuten * 1.99;
		}
	};

	private static Tarif instanceOf(TarifTyp tarif) {
		if (tarif == TarifTyp.PRIVAT) {
			return PRIVAT;
		} else if (tarif == TarifTyp.BUSINESS) {
			return new Business();
		} else if (tarif == TarifTyp.PROFI) {
			return new Profi();
		}
		throw new IllegalArgumentException(String.format("Tarifart %s ist ungültig", tarif));
	}
	public abstract double berechneGespraechspreis(int minuten, Zeitpunkt zeitpunkt);
}
