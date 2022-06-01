package ccsc.solid.dip.bad;

public class Service {
    private final Repository repository;

    public Service() {
        this.repository = new Repository("jdbc://");
    }

    public String getSomethingFromDB(String input) {
        return this.repository.read(input);
    }
}
