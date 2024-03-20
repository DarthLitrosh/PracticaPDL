import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class ClienteApi {
    private static final String BASE_URL = "http://localhost:8080/api";

    public static void crearUsuario(Usuario usuario) {
        HttpClient client = HttpClient.newHttpClient();
        Gson gson = new Gson(); // Instancia de Gson para la conversión
        String json = gson.toJson(usuario); // Convierte el usuario a JSON

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/usuarios"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        try {
            // Envía la solicitud y procesa la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            // Imprime el código de estado HTTP y la respuesta
            System.out.println("Response status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Asumiendo que tienes una clase Usuario en algún lugar de tu proyecto
    public static class Usuario {
        // Atributos, constructor, getters y setters...
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Usuario usuario = new Usuario(/* inicializa tu usuario aquí */);
        crearUsuario(usuario);
    }
}
