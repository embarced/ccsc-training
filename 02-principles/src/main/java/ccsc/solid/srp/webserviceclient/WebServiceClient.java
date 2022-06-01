package ccsc.solid.srp.webserviceclient;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.util.List;

public class WebServiceClient {
    private final UserMapper userMapper = new UserMapper();
    private String baseUrl;

    public WebServiceClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public List<Event> get(String path) throws URISyntaxException, IOException, InterruptedException {
        return userMapper.handleResponse(HttpClient.newBuilder().build(),
                new HttpRequestCreator(baseUrl + path).getGetRequest());
    }
}
