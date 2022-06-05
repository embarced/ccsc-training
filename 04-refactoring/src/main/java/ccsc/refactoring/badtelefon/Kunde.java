package ccsc.refactoring.badtelefon;

public class Kunde {
	private double gebuehr = 0.0;
	private final Tarif tarif;

	public Kunde(int tarifArt) {
		this.tarif = new Tarif(tarifArt);
	}

	public void bucheGespraech(int dauer, Zeitpunkt zeitpunkt) {
		gebuehr += tarif.ermittlePreis(dauer, zeitpunkt);
	}

	public double getGebuehr() {
		return gebuehr;
	}
}
