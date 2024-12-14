package com.currencyconverter.service;

import com.currencyconverter.http.ExchangeRateHttpClient;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.Map;
import java.util.Scanner;

// Clase auxiliar para deserializar el JSON
class ExchangeRateResponse {
    @SerializedName("rates")
    Map<String, Double> rates;
    @SerializedName("base")
    String base;
    @SerializedName("date")
    String date;
}

public class CurrencyConverterService {

    private final ExchangeRateHttpClient httpClient;
    private final Gson gson;

    public CurrencyConverterService() {
        this.httpClient = new ExchangeRateHttpClient();
        this.gson = new Gson();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n//////////////////////////////////////////////////");
            System.out.println("                     Menu:                        ");
            System.out.println("//////////////////////////////////////////////////");
            System.out.println("1. Convertir Dolar(USD) a Peso Argenitno(ARS) ");
            System.out.println("2. Convertir Peso Argentino (ARS) a  Dolar (USD)");
            System.out.println("3. Convertir Dolar (USD) a Peso Brasileño (BRL)");
            System.out.println("4. Convertir Peso Brasileño (BRL) a Dolar (USD)");
            System.out.println("5. Convertir Dolar (USD) a  Peso Colombiano (COP)");
            System.out.println("6. Convert Peso Colombiano (COP) a  Dolar (USD)");
            System.out.println("7. Salir");

            System.out.print("Elige una opcion: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    convertCurrency("USD", "ARS", scanner);
                    break;
                case 2:
                    convertCurrency("ARS", "USD", scanner);
                    break;
                case 3:
                    convertCurrency("USD", "BRL", scanner);
                    break;
                case 4:
                    convertCurrency("BRL", "USD", scanner);
                    break;
                case 5:
                    convertCurrency("USD", "COP", scanner);
                    break;
                case 6:
                    convertCurrency("COP", "USD", scanner);
                    break;
                case 7:
                    exit = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida. Elige una opcion entre el 1 -7 ");
            }
        }
        scanner.close();
    }

    private void convertCurrency(String sourceCurrency, String targetCurrency, Scanner scanner) {
        try {
            // Siempre obten las tasas con USD como base
            String response = httpClient.getExchangeRates("USD");
            ExchangeRateResponse exchangeRates = gson.fromJson(response, ExchangeRateResponse.class);

            // Verifica si ambas monedas existen en las tasas
            if (!exchangeRates.rates.containsKey(sourceCurrency) || !exchangeRates.rates.containsKey(targetCurrency)) {
                System.out.println("Conversion no disponible.");
                return;
            }

            // Calcula la tasa de conversión dependiendo de la moneda de origen
            double rate;
            if (sourceCurrency.equals("USD")) {
                rate = exchangeRates.rates.get(targetCurrency); // USD a otra moneda
            } else {
                rate = 1.0 / exchangeRates.rates.get(sourceCurrency); // Otra moneda a USD
            }

            System.out.print("Ingrese la cantidad en " + sourceCurrency + ": ");
            double amount = scanner.nextDouble();

            double convertedAmount = amount * rate; // Realiza la conversión
            System.out.printf("La conversión del monto es: %.2f %s%n", convertedAmount, targetCurrency);
        } catch (Exception e) {
            System.err.println("Error... " + e.getMessage());
        }
    }
}