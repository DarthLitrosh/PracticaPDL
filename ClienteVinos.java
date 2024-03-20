import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;

public class ClienteVinos {

    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String json = "{\"nombre\":\"Juan Pérez\",\"fechaNacimiento\":\"1990-05-15\",\"correoElectronico\":\"juan.perez@example.com\"}";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8080/api/usuarios"))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode);}}
