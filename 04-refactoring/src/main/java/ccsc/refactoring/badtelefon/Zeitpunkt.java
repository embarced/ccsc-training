package ccsc.refactoring.badtelefon;

import java.util.Date;
import java.util.StringJoiner;

public class Zeitpunkt {
    public static final int MONDSCHEINZEIT_ANFANG = 18;
    private final int stunde;
    private final int minute;

    private final Date date = new Date();

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

    public Date getDate() {
        return new Date(date.getTime());
    }

    @Override
    public String toString() {
        //return String.format("%s:%s Uhr", stunde, minute); // 10:30 Uhr
        return new StringJoiner(", ", Zeitpunkt.class.getSimpleName() + "[", "]")
                .add("stunde=" + stunde)
                .add("minute=" + minute)
                .add("date=" + date)
                .toString();
    }


    public static void main(String[] args) {
        Zeitpunkt zeitpunkt = new Zeitpunkt(10, 30);
        System.out.println(zeitpunkt);
        Date date1 = zeitpunkt.getDate();
        System.out.println(date1);
        date1.setTime(0);
        System.out.println(zeitpunkt);
        System.out.println(date1);
    }

    public boolean isMondschein() {
        int mondscheinzeitEnde = 9;
        return getStunde() < mondscheinzeitEnde || isNachtMondscheinZeitAnfang();
    }

    private boolean isNachtMondscheinZeitAnfang() {
        return getStunde() > MONDSCHEINZEIT_ANFANG;
    }
}
