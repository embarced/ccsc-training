package ccsc.solid.srp.webserviceclient;

import ccsc.solid.srp.webserviceclient.bad.WebServiceClient1;
import ccsc.solid.srp.webserviceclient.bad.WebServiceClient2;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        String baseUrl = "https://www.jug-da.de/";
        String path = "events.json";

        System.out.println("WebServiceClient1");
        WebServiceClient1 webClient1 = new WebServiceClient1(baseUrl);
        for (Event event: webClient1.get(path)) {
            System.out.println(event);
        }

        System.out.println();
        System.out.println("WebServiceClient2");
        WebServiceClient2 webClient2 = new WebServiceClient2(baseUrl);
        for (Event event: webClient2.get(path)) {
            System.out.println(event);
        }

/*
        WebServiceClient3 webClient3 = new WebServiceClient3(baseUrl);
        System.out.println(webClient3.get(path));
*/

    }
}
