package ccsc.refactoring.badtelefon;

import ccsc.refactoring.badtelefon.tarif.Tarif;

public class Kunde {
	private double gebuehr = 0.0;
	private Tarif tarif;

	public Kunde(int tarifArt) {
		this.tarif = Tarif.instanceOf(tarifArt);
	}

	public void bucheGespraech(int minuten, Zeitpunkt zeitpunkt) {
		gebuehr += tarif.berechneGespraechspreis(minuten, zeitpunkt);
	}

	public double getGebuehr() {
		return gebuehr;
	}

}
