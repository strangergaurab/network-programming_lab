import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SecureSocketEx {
    public static void main(String[] args) {
        try {
            // Create an SSL socket factory and connect to the server
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket) factory.createSocket("https://exam.tufohss.edu.np/", 442);

            // Enable all supported cipher suites
            String[] supported = socket.getSupportedCipherSuites();
            socket.setEnabledCipherSuites(supported);

            // Send an HTTP GET request
            Writer out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
            out.write("GET / HTTP/1.1\r\n");
            out.write("Host: https://exam.tufohss.edu.np/\r\n");
            out.write("\r\n");
            out.flush();

            // Read and print the server's response
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String s;
            while ((s = in.readLine()) != null && !s.isEmpty()) {
                System.out.println(s);
            }
        } catch (Exception e) {
            System.err.println("Error in processing: " + e.getMessage());
        }
    }
}
