package ccsc.refactoring.badtelefon;

public class Main {
	public static void main(String args[]) {
		Kunde k1 = new Kunde(Tarif.PROFI);

		k1.account(5, new Zeitpunkt(5, 30));
		k1.account(15, new Zeitpunkt(16, 0));
		k1.account(5, new Zeitpunkt(21, 0));

		System.out.println("Gebühr:" + k1.getGebuehr());
	}
}
