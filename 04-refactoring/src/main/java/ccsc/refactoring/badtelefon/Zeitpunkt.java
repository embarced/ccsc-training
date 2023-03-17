package ccsc.refactoring.badtelefon;

import java.util.StringJoiner;

public final class Zeitpunkt {
    public static final int MONDSCHEINZEIT_ENDE = 9;
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
        return isVorMondscheinzeitEnde() || isNachMondscheinzeitAnfang();
    }

    private boolean isVorMondscheinzeitEnde() {
        return getStunde() < MONDSCHEINZEIT_ENDE;
    }

    private boolean isNachMondscheinzeitAnfang() {
        return getStunde() > 18;
    }
}
