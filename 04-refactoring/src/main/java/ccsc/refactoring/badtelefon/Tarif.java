package ccsc.refactoring.badtelefon;

public class Tarif {
	public final static int PRIVAT = 0;
	public final static int BUSINESS = 1;
	public final static int PROFI = 2;

	int tarif = 0;

	public Tarif(int tarif) {
		this.tarif = tarif;
	}

    public double ermittlePreis(int dauer, Zeitpunkt zeitpunkt) {
        double preis = 0;

        // Gespraechspreis ermitteln
        switch (this.tarif) {
        case PRIVAT:
            dauer = dauer - 1;
            dauer = dauer < 0 ? 0 : dauer;
            if (zeitpunkt.isMondschein())
                preis = dauer * 0.69;
            else
                preis = dauer * 1.99;
            break;

        case BUSINESS:
            if (zeitpunkt.isMondschein())
                preis = dauer * 0.79;
            else
                preis = dauer * 1.29;
            break;

        case PROFI:
            preis = dauer * 0.69;
            break;

        }
        return preis;
    }
}
