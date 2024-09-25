
// program to check whether an IP address is ipv4 or ipv6

import java.net.InetAddress;

public class PrintAddress {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("https://fohss.tu.edu.np/");
            System.out.println(address.getHostAddress());
            if (address.getAddress().length == 4) {
                System.out.println(address.getHostAddress() + "is ipv4");
            } else if (address.getAddress().length == 16) {
                System.out.println(address.getHostAddress() + " is ipv6 address");
            }
        } catch (Exception e) {
            System.err.println("errro in processiong ");
        }

    }
}
