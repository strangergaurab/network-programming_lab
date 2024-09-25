import java.net.*;
import java.io.*;

public class DaytimeClient {
    public static void main(String[] args) {
        String hostname = "time.nist.gov"; // Default hostname
        try (Socket socket = new Socket(hostname, 13)) { // Connect to server
            socket.setSoTimeout(15000); // Set timeout to 15 seconds
            InputStream in = socket.getInputStream(); // Get input stream
            StringBuilder time = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(in, "ASCII");
            for (int c = reader.read(); c != -1; c = reader.read()) {
                time.append((char) c);
            }
            System.out.println(time); // Print the time received from the server
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
