import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPRequestMethod {
    public static void main(String[] args) {
        String urlString = "http://example.com";
        try {
            URL url = new URL(urlString);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET"); // You can change this to "POST", "PUT", etc.
            System.out.println("HTTP Request Method: " + httpURLConnection.getRequestMethod());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
