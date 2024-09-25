import java.net.NetworkInterface;
import java.util.Collection;
import java.util.Enumeration;

public class NetworkInterfaceGetter {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface ni : Collection.list(interfaces)) {
                System.out.println(ni.getDisplayName());

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
