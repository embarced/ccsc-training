package ccsc.refactoring.badtelefon;

import ccsc.refactoring.badtelefon.tarif.Tarif;
import ccsc.refactoring.badtelefon.tarif.TarifTyp;

public class Kunde {
	private double gebuehr = 0.0;
	private TarifTyp tarif;

	public Kunde(TarifTyp tarif) {
		this.tarif = tarif; //Tarif.instanceOf(tarif);
	}

	public void bucheGespraech(int minuten, Zeitpunkt zeitpunkt) {
		gebuehr += tarif.berechneGespraechspreis(minuten, zeitpunkt);
	}

	public double getGebuehr() {
		return gebuehr;
	}

}
