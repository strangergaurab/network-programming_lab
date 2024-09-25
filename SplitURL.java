import java.net.URL;

public class SplitURL {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com:80/path/to/resource?query=example#fragment");
            System.out.println("protocol" + url.getProtocol());
            System.out.println("Host" + url.getHost());
            System.out.println("Port:" + url.getPort());
            System.out.println("Path" + url.getPath());
            System.out.println("query" + url.getQuery());
            System.out.println("fragment:" + url.getRef());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
