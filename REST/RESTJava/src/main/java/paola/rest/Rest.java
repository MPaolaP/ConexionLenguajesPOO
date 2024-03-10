/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package paola.rest;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Rest {
    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            String url = "http://localhost:5000/convert?temperature=1000&unit=celsius"; 
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();
            
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            
            System.out.println("Response status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());
        } catch (Exception e) {
            System.out.println("Error during the request: " + e.getMessage());
        }
    }
}

