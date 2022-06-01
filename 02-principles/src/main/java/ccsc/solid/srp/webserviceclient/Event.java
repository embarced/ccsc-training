package ccsc.solid.srp.webserviceclient;

public class Event {
    private String speaker;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.speaker, this.title);
    }
}
