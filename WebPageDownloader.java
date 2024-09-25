import java.io.*;
import java.net.*;

public class WebPageDownloader {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://en.wikipedia.org/wiki/Nepal");
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

            // Set request method and properties if needed
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");

            // Get the input stream and read the content
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    BufferedWriter out = new BufferedWriter(new FileWriter("downloaded_page.html"))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    out.write(inputLine);
                    out.newLine();
                }
            }

            // Disconnect the connection
            conn.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
