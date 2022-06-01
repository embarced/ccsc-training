package ccsc.solid.srp.webserviceclient;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

public class HttpRequestCreator {
    private final URI uri;

    public HttpRequestCreator(String url) {
        try {
            this.uri = new URI(url);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(String.format("Could not create URI from %s", url), e);
        }
    }

    HttpRequest getGetRequest() throws URISyntaxException {
        return HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
    }
}