package ccsc.refactoring.badtelefon;

public class Kunde {
	private double gebuehr = 0.0;
	private Tarif tarif;

	public Kunde(int tarifArt) {
		this.tarif = new Tarif(tarifArt);
	}

	public void bucheGespraech(int minuten, Zeitpunkt zeitpunkt) {
		gebuehr += tarif.berechneGespraechspreis(minuten, zeitpunkt);
	}

	public double getGebuehr() {
		return gebuehr;
	}

}
