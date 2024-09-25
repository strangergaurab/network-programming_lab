import java.util.Arrays;
import java.util.List;

public class CheckSupportedProtocols {
    public static void main(String[] args) {
        List<String> supportedProtocols = Arrays.asList("HTTP", "HTTPS", "FTP", "SMTP");
        String protocolToCheck = "HTTP";
        if (supportedProtocols.contains(protocolToCheck.toUpperCase())) {
            System.out.println(protocolToCheck + " is supported");

        } else {
            System.out.println(protocolToCheck + "is not supported");
        }
    }
}
