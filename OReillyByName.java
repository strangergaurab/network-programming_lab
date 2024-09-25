
import java.net.*;

public class OReillyByName {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.youtube.com");
            System.out.println(address);
        } catch (Exception e) {
            System.out.println("Could not find");
        }
    }
}
