package ccsc.refactoring.badtelefon;

import ccsc.refactoring.badtelefon.tarif.BusinessTarif;
import ccsc.refactoring.badtelefon.tarif.PrivatTarif;
import ccsc.refactoring.badtelefon.tarif.ProfiTarif;

public class Kunde {
	private double gebuehr = 0.0;
	private Tarif tarif;

	public Kunde(int tarifArt) {
		tarif = switch (tarifArt) {
			case Tarif.PRIVAT -> new PrivatTarif();
			case Tarif.BUSINESS -> new BusinessTarif();
			case Tarif.PROFI -> new ProfiTarif();
			default -> throw new RuntimeException("Tarifart ist nicht gültig: " + tarifArt);
		};
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
