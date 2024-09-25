import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class HeaderViewer {
    public static void main(String[] args) {
        try {
            String resources = "https://tu.edu.np/";
            URI uri = new URI(resources);
            URL url = uri.toURL();
            URLConnection conn = url.openConnection();

            String contentType = conn.getContentType();
            System.out.println("Content Type: " + contentType);

            int contentLength = conn.getContentLength();
            System.out.println("Content Length: " + contentLength);

            String contentEncoding = conn.getContentEncoding();
            System.out.println("Content Encoding: " + contentEncoding);

            long dateInMillis = conn.getDate();
            Date documentSend = new Date(dateInMillis);
            System.out.println("Document Sent Date: " + documentSend);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
