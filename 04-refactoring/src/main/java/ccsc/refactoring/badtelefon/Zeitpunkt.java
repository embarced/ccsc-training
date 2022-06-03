package ccsc.refactoring.badtelefon;

import java.util.StringJoiner;

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
        return new StringJoiner(", ", Zeitpunkt.class.getSimpleName() + "[", "]")
                .add("stunde=" + stunde)
                .add("minute=" + minute)
                .toString();
    }

    public boolean isMondschein() {
        int MONDSCHEINZEIT_ENDE = 9;
        return getStunde() < MONDSCHEINZEIT_ENDE || istNachMondscheinzeitAnfang();
    }

    private boolean istNachMondscheinzeitAnfang() {
        return getStunde() > MONDSCHEINZEIT_ANFANG;
    }
}
