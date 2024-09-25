import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

class DaytimeThread extends Thread {
    private Socket connection;

    DaytimeThread(Socket connection) {
        this.connection = connection;
    }

    public void run() {
        try {
            Writer out = new OutputStreamWriter(connection.getOutputStream());
            Date now = new Date();
            out.write(now.toString() + "\r\n");
            out.flush();
            out.close();
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                // ignore
            }
        }
    }
}

public class MultithreadedDaytimeServer {
    public final static int PORT = 12345; // Use a higher port number

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try {
                    Socket connection = server.accept();
                    Thread task = new DaytimeThread(connection);
                    task.start();
                } catch (IOException e) {
                    System.err.println("Error in processing: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Could not start server: " + e.getMessage());
        }
    }
}
