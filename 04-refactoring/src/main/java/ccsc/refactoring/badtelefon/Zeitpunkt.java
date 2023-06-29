package ccsc.refactoring.badtelefon;

import java.util.StringJoiner;

public record Zeitpunkt(int stunde, int minute) {
    public static final int MONDSCHEINZEIT_ENDE = 9;
    @Override
    public String toString() {
        return String.format("Zeitpunkt: %s:%s", stunde, minute);
    }

    public boolean isMondscheinZeit() {
        return stunde() < MONDSCHEINZEIT_ENDE || isMondscheinzeitAnfang();
    }

    private boolean isMondscheinzeitAnfang() {
        return stunde() > 18;
    }
}
