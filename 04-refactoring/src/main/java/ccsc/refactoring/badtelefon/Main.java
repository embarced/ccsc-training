package ccsc.refactoring.badtelefon;

public class Main {
	public static void main(String args[]) {
		Kunde k1 = new Kunde(Tarif.PROFI);

		k1.account(5, 5, 30);
		k1.account(15, 16, 0);
		k1.account(5, 21, 0);

		System.out.println("Gebühr:" + k1.getGebuehr());
	}
}
