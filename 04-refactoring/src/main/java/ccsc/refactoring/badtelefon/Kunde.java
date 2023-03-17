package ccsc.refactoring.badtelefon;

import ccsc.refactoring.badtelefon.tarif.*;

public class Kunde {
	private double gebuehr = 0.0;
	private final Tarif tarif;

	@Deprecated(forRemoval = true)
	public Kunde(TarifArt tarifArt) {
		tarif = switch (tarifArt) {
			case PRIVAT -> new PrivatTarif();
			case BUSINESS -> new BusinessTarif();
			case PROFI -> new ProfiTarif();
		};
	}

	public void account(int minuten, Zeitpunkt zeitpunkt) {
		this.gebuehr = gebuehr + tarif.berechneGebuehr(minuten, zeitpunkt);
	}

	public double getGebuehr() {
		return gebuehr;
	}

	public Tarif getTarif() {
		return tarif;
	}
}
