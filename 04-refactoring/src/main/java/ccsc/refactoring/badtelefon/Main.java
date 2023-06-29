package ccsc.refactoring.badtelefon;

import ccsc.refactoring.badtelefon.tarif.Tarif;

public class Main {
	public static void main(String args[]) {
		Kunde k1 = new Kunde(Tarif.PROFI);

		k1.bucheGespraech(5, new Zeitpunkt(5, 30));
		k1.bucheGespraech(15, new Zeitpunkt(16, 0));
		k1.bucheGespraech(5, new Zeitpunkt(21, 0));

		System.out.println("Gebühr:" + k1.getGebuehr());
	}
}
