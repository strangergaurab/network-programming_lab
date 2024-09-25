import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class URLSplitter {
    public static void main(String[] args) {
        try {
            // Example URL
            String urlString = "https://www.example.com:8080/path/to/resource?name=value#section";
            URI uri = new URI(urlString);
            URL url = uri.toURL();

            // Display the parts of the URL
            System.out.println("URL: " + urlString);
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + (url.getPort() == -1 ? "default" : url.getPort()));
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("Reference: " + url.getRef());
        } catch (URISyntaxException e) {
            System.err.println("URI Syntax exception: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.err.println("Malformed URL: " + e.getMessage());
        }
    }
}
