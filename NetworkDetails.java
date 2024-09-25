
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class NetworkDetails {
    public static void main(String[] args) {
        try {
            // Get the local host address
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("IP Address: " + localHost.getHostAddress());

            // Get the network interface for the local host
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(localHost);
            if (networkInterface != null) {
                byte[] macAddress = networkInterface.getHardwareAddress();
                if (macAddress != null) {
                    StringBuilder macAddressStr = new StringBuilder();
                    for (int i = 0; i < macAddress.length; i++) {
                        macAddressStr
                                .append(String.format("%02X%s", macAddress[i], (i < macAddress.length - 1) ? "-" : ""));
                    }
                    System.out.println("MAC Address: " + macAddressStr.toString());
                } else {
                    System.out.println("MAC Address not found.");
                }
            } else {
                System.out.println("Network Interface for the specified host is not found.");
            }
        } catch (UnknownHostException e) {
            System.err.println("Host not found: " + e.getMessage());
        } catch (SocketException e) {
            System.err.println("Socket exception: " + e.getMessage());
        }
    }
}
