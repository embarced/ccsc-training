package ccsc.refactoring.badtelefon;

public class Kunde {
	private double gebuehr = 0.0;
	private Tarif tarif;

	public Kunde(int tarifArt) {
		this.setTarif(new Tarif(tarifArt));
	}

	public void account(int minuten, Zeitpunkt zeitpunkt) {
		this.gebuehr = getGebuehr() + tarif.berechneGebuehr(minuten, zeitpunkt);
	}

	public double getGebuehr() {
		return gebuehr;
	}

	public Tarif getTarif() {
		return tarif;
	}

	public void setTarif(Tarif tarif) {
		this.tarif = tarif;
	}
}
