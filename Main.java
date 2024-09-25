import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        try {
            // Create an instance of HttpClient
            HttpClient client = HttpClient.newHttpClient();

            // Create the request object
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://fohss.tu.edu.np/notices/4598"))
                    .GET() // Specify GET request
                    .build();

            // Send the request and receive the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print the status code and response body
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Server's Response: ");
            System.out.println(response.body());

        } catch (Exception e) {
            System.out.println("Error communicating with the server: " + e.getMessage());
        }
    }
}
