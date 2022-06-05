package ccsc.refactoring.badtelefon;

public class Kunde {
	double gebuehr = 0.0;
	Tarif tarif;

	public Kunde(int tarifArt) {
		this.tarif = new Tarif(tarifArt);
	}

	public void account(int minuten, Zeitpunkt zeitpunkt) {
		double preis = 0;

		// Gespraechspreis ermitteln
		switch (tarif.tarif) {
		case Tarif.PRIVAT:
			minuten = minuten - 1;
			minuten = minuten < 0 ? 0 : minuten;
			if (zeitpunkt.isMondschein())
				preis = minuten * 0.69;
			else
				preis = minuten * 1.99;
			break;

		case Tarif.BUSINESS:
			if (zeitpunkt.isMondschein())
				preis = minuten * 0.79;
			else
				preis = minuten * 1.29;
			break;

		case Tarif.PROFI:
			preis = minuten * 0.69;
			break;

		}

		gebuehr += preis;
	}

	public double getGebuehr() {
		return gebuehr;
	}
}
