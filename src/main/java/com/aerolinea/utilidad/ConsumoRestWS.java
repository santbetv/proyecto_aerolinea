package com.aerolinea.utilidad;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Clase diseñada para servir de puente para el consumo desde cualquier otra
 * clase de servicios web rest - post
 *
 * @author Santiago Betancur V
 *
 */
public class ConsumoRestWS {

    /**
     * Metodo encargado de consumir un servicio web rest - post con envio de
     * Este metodo siempre retorna un String[] con dos posiciones [0] es
     * el estado del consumo: true - false [1] es el detalle de la
     * respuesta(Objeto JSON): {"":""}
     * @param data
     * @param ruta
     * @param token
     * @return 
     */
    public static String[] comsumoRestPost(String data, String ruta, String token) {

        String[] response = new String[2];
        try {
            String urlParameters = data;
            byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
            String request = ruta;
            URL url = new URL(request.trim());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestMethod("POST");
            if (!token.equals("")) {
                conn.setRequestProperty("Authorization", token);
            }
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("charset", "utf-8");
            conn.setUseCaches(false);
            try {
                OutputStream wr = conn.getOutputStream();
                wr.write(postData);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (int c; (c = in.read()) >= 0;) {
                sb.append((char) c);
            }
            response[0] = "true";
            response[1] = sb.toString();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Error consumiendo al Servicio");
            e.printStackTrace();
            response[0] = "false";
            response[1] = "{\"mensaje\":\"04--Error validando--Sin permisos\"}";
        }
        return response;
    }
}
