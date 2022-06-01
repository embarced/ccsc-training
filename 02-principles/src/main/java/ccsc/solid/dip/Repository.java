package ccsc.solid.dip;

public class Repository {
    private final String dbUrl;

    public Repository(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String read(String input) {
        // read from DB
        return "";
    }
}
