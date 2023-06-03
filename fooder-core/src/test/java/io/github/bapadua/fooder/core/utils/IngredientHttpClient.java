package io.github.bapadua.fooder.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bapadua.fooder.core.dto.IngredientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class IngredientHttpClient {

    private final String SERVER_URL = "http://localhost";

    private final int port = 8088;
    private final ObjectMapper mapper = new ObjectMapper();


    @Autowired
    private HttpClient httpClient;

    public HttpResponse<String> get(String endpoint) throws URISyntaxException, IOException, InterruptedException {
        return get(HttpRequest.newBuilder()
                .uri(getUri(endpoint))
                .GET()
                .build());
    }

    public HttpResponse<String> post(String endpoint, IngredientDTO ingredient) throws IOException, URISyntaxException, InterruptedException {
        return post(endpoint, mapper.writeValueAsString(ingredient));
    }

    public HttpResponse<String> post(String endpoint, String json) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(getUri(endpoint))
                .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> get(HttpRequest request) throws IOException, InterruptedException {
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public <T> T get(HttpRequest request, Class<T> clazz) throws IOException, InterruptedException {
        HttpResponse<String> response = get(request);
        return mapper.convertValue(response.body(), clazz);
    }

    private URI getUri(String endpoint) throws URISyntaxException {
        return new URI(String.format("%s:%d%s", SERVER_URL, port, endpoint));
    }
}
