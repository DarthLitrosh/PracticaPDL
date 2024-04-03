package Soso.src.main.java;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

public class ClienteVinos {

    private HttpClient client;
    private String baseUrl;

    public ClienteVinos(String baseUrl) {
        this.client = HttpClient.newHttpClient();
        this.baseUrl = baseUrl;
    }

    public void crearUsuario(String jsonUsuario) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/usuarios"))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(jsonUsuario))
                .build();

        enviarSolicitud(request);
    }

    public void obtenerUsuario(int idUsuario) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/usuarios/" + idUsuario))
                .header("Accept", "application/json")
                .GET()
                .build();

        enviarSolicitud(request);
    }

    public void actualizarUsuario(int idUsuario, String jsonUsuarioActualizado) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/usuarios/" + idUsuario))
                .header("Content-Type", "application/json")
                .PUT(BodyPublishers.ofString(jsonUsuarioActualizado))
                .build();

        enviarSolicitud(request);
    }

    public void eliminarUsuario(int idUsuario) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/usuarios/" + idUsuario))
                .DELETE()
                .build();

        enviarSolicitud(request);
    }

    private void enviarSolicitud(HttpRequest request) {
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());
        } catch (InterruptedException e) {
            System.err.println("Request was interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ClienteVinos cliente = new ClienteVinos("http://localhost:8080/api");

        // Ejemplo de uso
        // Ejemplo de uso
        String jsonUsuario = "{\"nombre\":\"Juan Pérez\",\"fechaNacimiento\":\"1990-05-15\",\"correoElectronico\":\"juan.perez@example.com\"}";
        cliente.crearUsuario(jsonUsuario);

        // Suponiendo que queremos obtener un usuario con ID 1
        cliente.obtenerUsuario(1);

        // Actualizar usuario con ID 1
        String jsonUsuarioActualizado = "{\"nombre\":\"Juan Pérez Actualizado\",\"fechaNacimiento\":\"1990-05-15\",\"correoElectronico\":\"juan.perez.actualizado@example.com\"}";
        cliente.actualizarUsuario(1, jsonUsuarioActualizado);

        // Eliminar usuario con ID 1
        cliente.eliminarUsuario(1);
    }
}
