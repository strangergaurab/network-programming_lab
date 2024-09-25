import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class URILastChanged {
    public static void main(String[] args) {
        String urlString = "http://example.com";
        try {
            URL url = new URL(urlString);
            URLConnection urlConnection = url.openConnection();
            long lastModified = urlConnection.getLastModified();
            if (lastModified == 0) {
                System.out.println("No last modified information.");
            } else {
                System.out.println("Last Modified: " + new java.util.Date(lastModified));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
