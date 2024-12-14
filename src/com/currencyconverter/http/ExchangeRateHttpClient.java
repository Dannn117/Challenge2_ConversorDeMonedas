package com.currencyconverter.http;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class ExchangeRateHttpClient {

    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public String getExchangeRates(String baseCurrency) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + baseCurrency))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("No se han podido recuperar los tipos de cambio: " + response.statusCode());
        }
        return response.body();
    }
}
