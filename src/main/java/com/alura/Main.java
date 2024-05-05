package com.alura;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String menu = """
               *************************************************************
               
               *** Escriba el numero de la opcion deseada ***
               *** Convertir:
               
               1 - Nuevo Sol (PEN) a Dolar (USD)
               2 - Dolar (USD) a Nuevo Sol (PEN)
               3 - Nuevo Sol (PEN) a Euro (EUR)
               4 - Euro (EUR) a Nuevo Sol (PEN)
               5 - Nuevo Sol (PEN) a Yen (JPY)
               6 - Yen (JPY) a Nuevo Sol (PEN)
               7 - Nuevo Sol (PEN) a Peso Argentino (ARS)
               8 - Peso Argentino (ARS) a Nuevo Sol (PEN)
               9 - Salir
               
               *************************************************************
                """;

            System.out.println(menu);
            System.out.print("Opción: ");

            int opcion = scanner.nextInt();
            double cantidad;

            if (opcion == 9) {
                System.out.println("Saliendo...");
                break;
            }

            System.out.print("Ingrese la cantidad a convertir: ");
            cantidad = scanner.nextDouble();

            String monedaOrigen = "";
            String monedaDestino = "";

            switch (opcion) {
                case 1:
                    monedaOrigen = "PEN";
                    monedaDestino = "USD";
                    break;
                case 2:
                    monedaOrigen = "USD";
                    monedaDestino = "PEN";
                    break;
                case 3:
                    monedaOrigen = "PEN";
                    monedaDestino = "EUR";
                    break;
                case 4:
                    monedaOrigen = "EUR";
                    monedaDestino = "PEN";
                    break;
                case 5:
                    monedaOrigen = "PEN";
                    monedaDestino = "JPY";
                    break;
                case 6:
                    monedaOrigen = "JPY";
                    monedaDestino = "PEN";
                    break;
                case 7:
                    monedaOrigen = "PEN";
                    monedaDestino = "ARS";
                    break;
                case 8:
                    monedaOrigen = "ARS";
                    monedaDestino = "PEN";
                    break;
                default:
                    System.out.println("Opción inválida.");
                    continue;
            }

            // Codigo para realizar la conversión de moneda
            double resultado = realizarConversion(cantidad, monedaOrigen, monedaDestino);
            System.out.printf("%.2f %s = %.2f %s%n", cantidad, monedaOrigen, resultado, monedaDestino);
        }
    }

    public static double realizarConversion(double cantidad, String monedaOrigen, String monedaDestino) {
        double tipoCambio = obtenerTipoCambio(monedaOrigen, monedaDestino);
        return cantidad * tipoCambio;
    }

    public static double obtenerTipoCambio(String monedaOrigen, String monedaDestino) {
        String apiKey = "1c0c00b1cb3938fd014c9e62";
        String apiUrl = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + monedaOrigen;

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Codigo que analiza la respuesta JSON y obtiene el tipo de cambio deseado
            double tipoCambio = obtenerTipoCambioDesdeJSON(response.toString(), monedaDestino);
            return tipoCambio;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static double obtenerTipoCambioDesdeJSON(String jsonResponse, String monedaDestino) {
        // Analizar la respuesta JSON y extraer el tipo de cambio para la moneda de destino
        double tipoCambio = -1;
        try {
            // Convertir la respuesta JSON en un objeto de tipo RateResponse
            RateResponse rateResponse = new Gson().fromJson(jsonResponse, RateResponse.class);
            // Obtener el tipo de cambio para la moneda de destino
            tipoCambio = rateResponse.conversion_rates.get(monedaDestino);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoCambio;
    }
}

class RateResponse {
    Map<String, Double> conversion_rates;
}


