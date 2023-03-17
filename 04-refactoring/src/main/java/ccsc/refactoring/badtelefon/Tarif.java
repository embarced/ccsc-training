package ccsc.refactoring.badtelefon;

public class Tarif {
	public final static int PRIVAT = 0;
	public final static int BUSINESS = 1;
	public final static int PROFI = 2;

	int tarif = 0;

	public Tarif(int tarif) {
		this.tarif = tarif;
	}

	public double berechneGebuehr(int minuten, Zeitpunkt zeitpunkt) {
		double preis = 0;

		// Gespraechspreis ermitteln
		switch (tarif) {
		case PRIVAT:
			minuten = minuten - 1;
			minuten = minuten < 0 ? 0 : minuten;
			if (zeitpunkt.isMondschein())
				preis = minuten * 0.69;
			else
				preis = minuten * 1.99;
			break;

		case BUSINESS:
			if (zeitpunkt.isMondschein())
				preis = minuten * 0.79;
			else
				preis = minuten * 1.29;
			break;

		case PROFI:
			preis = minuten * 0.69;
			break;

		}
		return preis;
	}
}
