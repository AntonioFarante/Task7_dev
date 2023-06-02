package MethodsToGetCats;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {
    private final String URL_CATS = "https://http.cat";


    public String getStatusImage(int code) throws IOException, InterruptedException, URISyntaxException {
        String result = "";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpUriRequest request = new HttpGet(URL_CATS + "/" + code);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            if (response.getStatusLine().toString().contains("404")) {
                result =  URL_CATS + "/404";
                throw new FileNotFoundException();
            } else result = URL_CATS + "/" + code;
        }
        return result;
    }
}
