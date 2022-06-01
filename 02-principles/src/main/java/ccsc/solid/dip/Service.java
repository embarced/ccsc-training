package ccsc.solid.dip;

import ccsc.solid.dip.bad.Repository;

public class Service {
    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public String getSomethingFromDB(String input) {
        return this.repository.read(input);
    }
}
