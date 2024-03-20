
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;

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

        String jsonUsuario = "{\"nombre\":\"Juan Pérez\",\"fechaNacimiento\":\"1990-05-15\",\"correoElectronico\":\"juan.perez@example.com\"}";
        cliente.crearUsuario(jsonUsuario);

        // Aquí podrías agregar más llamadas a otros métodos, por ejemplo:
        // cliente.obtenerUsuario(idUsuario);
        // cliente.actualizarUsuario(jsonUsuarioActualizado);
        // cliente.eliminarUsuario(idUsuario);
    }
}
