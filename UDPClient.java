import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a number: ");
            String bsYearStr = scanner.nextLine();
            byte[] sendBuffer = bsYearStr.getBytes();

            // Send the BS year to the server
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, 9876);
            clientSocket.send(sendPacket);

            // Receive the AD year from the server
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);

            String factoril = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("the factorila number: " + factoril);
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
