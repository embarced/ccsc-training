package ccsc.refactoring.badtelefon;

public abstract class Tarif {
	public final static int PRIVAT = 0;
	public final static int BUSINESS = 1;
	public final static int PROFI = 2;

	int tarif = 0;

	public Tarif(int tarif) {
		this.tarif = tarif;
	}

	public abstract double berechneGebuehr(int minuten, Zeitpunkt zeitpunkt);
}
