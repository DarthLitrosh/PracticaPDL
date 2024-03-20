import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class ClienteApi {
    private static final String BASE_URL = "http://localhost:8080/api";

    public static void crearUsuario(Usuario usuario) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/usuarios"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(new Gson().toJson(usuario)))
                .build();

        // Envía la solicitud y procesa la respuesta
}
}
