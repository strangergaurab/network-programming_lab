import java.net.*;

public class ProtocolTester {
    public static void main(String[] args) {
        String[] urls = {
                "http://www.adc.org", // hypertext transfer protocol
                "https://www.amazon.com/exec/obidos/order2/", // secure http
                "ftp://ibiblio.org/pub/languages/java/javafaq/", // file transfer protocol
                "mailto:elharo@ibiblio.org", // Simple Mail Transfer Protocol
                "telnet://dibner.poly.edu/", // telnet
                "file:///etc/passwd", // local file access
                "gopher://gopher.anc.org.za/", // gopher
                "ldap://ldap.itd.umich.edu/o=University%20of%20Michigan,c=US?postalAddress", // Lightweight Directory
                                                                                             // Access Protocol
                "jar:http://cafeaulait.org/books/javaio/ioexamples/javaio.jar!/com/macfaq/io/StreamCopier.class", // JAR
                "nfs://utopia.poly.edu/usr/tmp/", // Network File System
                "jdbc:mysql://luna.ibiblio.org:3306/NEWS", // custom protocol for JDBC
                "rmi://ibiblio.org/RenderEngine", // custom protocol for remote method invocation
                "doc:/UsersGuide/release.html", // custom protocols for HotJava
                "netdoc:/UsersGuide/release.html",
                "systemresource://www.adc.org/+/index.html",
                "verbatim:http://www.adc.org/"
        };

        for (String url : urls) {
            testProtocol(url);
        }
    }

    private static void testProtocol(String url) {
        try {
            URI uri = new URI(url);
            URL u = uri.toURL();
            System.out.println(u.getProtocol() + " is supported");
        } catch (URISyntaxException | MalformedURLException ex) {
            int colonIndex = url.indexOf(':');
            if (colonIndex != -1) {
                String protocol = url.substring(0, colonIndex);
                System.out.println(protocol + " is not supported");
            } else {
                System.out.println("Invalid URL format");
            }
        }
    }
}
