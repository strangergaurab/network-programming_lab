import java.net.InetAddress;

public class TestIpAddresscharacter {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.tufohs.edu.np");
            byte[] ipAdr = address.getAddress();
            for (byte b : ipAdr) {
                System.out.println((b));
            }
        } catch (Exception e) {

        }
    }
}
