import java.net.*;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;

public class SecureSourceViewer {
    public static void main(String[] args) {
        Authenticator.setDefault(new DialogAuthenticator());

        HttpClient client = HttpClient.newBuilder()
                .authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new DialogAuthenticator().getPasswordAuthentication();
                    }
                })
                .build();

        for (String arg : args) {
            try {
                URI uri = new URI(arg);
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(uri)
                        .build();

                CompletableFuture<HttpResponse<String>> response = client.sendAsync(request, BodyHandlers.ofString());

                response.thenAccept(res -> {
                    System.out.println(res.body());
                }).join();

            } catch (URISyntaxException e) {
                System.err.println(arg + " is not a valid URI");
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        // Since we used the AWT, we have to explicitly exit.
        System.exit(0);
    }
}
