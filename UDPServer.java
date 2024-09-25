import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        try (DatagramSocket serverSocket = new DatagramSocket(9876)) {
            byte[] receiveBuffer = new byte[1024];

            System.out.println("Server is running...");

            while (true) {
                // Receive the BS year from the client
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                serverSocket.receive(receivePacket);

                String bsYearStr = new String(receivePacket.getData(), 0, receivePacket.getLength());
                int num = Integer.parseInt(bsYearStr);

                // Convert BS to AD
                int factorial = 1;
                for (int i = 1; i < num; i++) {
                    factorial = factorial * i;
                }

                String fact = String.valueOf(factorial);

                // Send the AD year back to the client
                byte[] sendBuffer = fact.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length,
                        receivePacket.getAddress(), receivePacket.getPort());
                serverSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
