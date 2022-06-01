package ccsc.solid.srp.webserviceclient.bad;

import ccsc.solid.srp.webserviceclient.Event;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;


public class WebServiceClient1 {
    private String baseUrl;

    public WebServiceClient1(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public List<Event> get(String path) throws URISyntaxException, IOException, InterruptedException {
        HttpResponse<String> response = HttpClient.newBuilder().build().send(HttpRequest.newBuilder()
                .uri(new URI(baseUrl + path))
                .GET()
                .build(), HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        List<Event> events = Arrays.asList(mapper.readValue(response.body(), Event[].class));

        return events;
    }
}
