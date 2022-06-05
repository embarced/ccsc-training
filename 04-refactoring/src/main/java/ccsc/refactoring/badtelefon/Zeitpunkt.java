package ccsc.refactoring.badtelefon;

public class Zeitpunkt {
    public static final int MONDSCHEINZEIT_ANFANG = 18;
    private final int stunde;
    private final int minute;

    public Zeitpunkt(int stunde, int minute) {
        this.stunde = stunde;
        this.minute = minute;
    }

    public int getStunde() {
        return stunde;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return String.format("%s:%s Uhr", stunde, minute);
    }

    public boolean isMondschein() {
        int mondscheinZeitEnde = 9;
        return getStunde() < mondscheinZeitEnde || getStunde() > MONDSCHEINZEIT_ANFANG;
    }
}
