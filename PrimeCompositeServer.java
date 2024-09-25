import java.io.*;
import java.net.*;

public class PrimeCompositeServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Create a new thread for each client using ClientHandler
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true)) {

            String numberStr;

            while ((numberStr = reader.readLine()) != null) {
                int number = Integer.parseInt(numberStr);

                if (isPrime(number)) {
                    writer.println(number + " is a prime number.");
                } else {
                    writer.println(number + " is a composite number.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
