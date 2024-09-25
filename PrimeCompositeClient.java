import java.io.*;
import java.net.*;

public class PrimeCompositeClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {

            String numberStr;

            while (true) {
                System.out.print("Enter a number (or 'exit' to quit): ");
                numberStr = consoleReader.readLine();

                if (numberStr.equalsIgnoreCase("exit")) {
                    break;
                }

                writer.println(numberStr);

                String response = reader.readLine();
                System.out.println("Server: " + response);
            }
        } catch (UnknownHostException e) {
            System.out.println("Server not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }
}
