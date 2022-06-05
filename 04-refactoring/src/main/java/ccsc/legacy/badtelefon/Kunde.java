package ccsc.legacy.badtelefon;

public class Kunde {
	double gebuehr = 0.0;
	Tarif tarif;

	public Kunde(int tarifArt) {
		this.tarif = new Tarif(tarifArt);
	}

	public void account(int minuten, int stunde, int minute) {
		System.out.println(String.format("Berechne Gespräch mit %02d min um %02d:%02d mit Tarif %s", minuten, stunde, minute, tarif.tarif));
		boolean mondschein = false;
		double preis = 0;

		// Mondscheinzeit ?
		if (stunde < 9 || stunde > 18)
			mondschein = true;

		// Gespraechspreis ermitteln
		double d = 0.69;
		switch (tarif.tarif) {
		case Tarif.PRIVAT:
			minuten = getNettoMinuten(minuten);
			if (mondschein)
				preis = berechnePreis(minuten, d);
			else
				preis = minuten * 1.99;
			break;

		case Tarif.BUSINESS:
			if (mondschein)
				preis = minuten * 0.79;
			else
				preis = minuten * 1.29;
			break;

		case Tarif.PROFI:
			preis = berechnePreis(minuten, d);
			break;

		}
		System.out.println(String.format("Preis für das Gespräch: %.2f", preis));
		
		gebuehr += preis;
		System.out.println(String.format("Gesamtgebühr nach Gespräch um %02d:%02d (Mondscheinzeit: %s): %.2f", stunde, minute, mondschein, gebuehr));
	}

	private double berechnePreis(int minuten, double d) {
		double preis;
		preis = minuten * d;
		return preis;
	}

	private static int getNettoMinuten(int minuten) {
		minuten = minuten - 1;
		minuten = minuten < 0 ? 0 : minuten;
		return minuten;
	}

	public double getGebuehr() {
		return gebuehr;
	}
}
