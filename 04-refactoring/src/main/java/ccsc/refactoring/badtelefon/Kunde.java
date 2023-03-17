package ccsc.refactoring.badtelefon;

import ccsc.refactoring.badtelefon.tarif.*;

public class Kunde {
	private double gebuehr = 0.0;
	private final TarifArt tarif;

	@Deprecated(forRemoval = true)
	public Kunde(TarifArt tarifArt) {
		tarif = tarifArt;
		//tarif = Tarif.createTarif(tarifArt);
	}

	public void account(int minuten, Zeitpunkt zeitpunkt) {
		this.gebuehr = gebuehr + tarif.berechneGebuehr(minuten, zeitpunkt);
	}

	public double getGebuehr() {
		return gebuehr;
	}

}
