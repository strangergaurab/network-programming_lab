// import java.io.DataInputStream;
// import java.io.DataOutputStream;
// import java.net.Socket;

// public class ChatClient {
//     public static void main(String[] args) {
//         try {
//             Socket s = new Socket("localhost", 6666);
//             DataOutputStream dout = new DataOutputStream(s.getOutputStream());
//             dout.writeUTF("Hello Server");
//             DataInputStream diso = new DataInputStream(s.getInputStream());
//             String ser = (String) diso.readUTF();
//             System.out.println("Server Message : " + ser);
//             dout.flush();
//         } catch (Exception e) {
//             System.out.println("Something went wrong");
//         }
//     }

// }
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 5000);
            DataOutputStream dis = new DataOutputStream(s.getOutputStream());
            dis.writeUTF("Hello Server");
            DataInputStream cdis = new DataInputStream(s.getInputStream());
            String str = (String) cdis.readUTF();
            System.out.println("the message from server is " + str);
            cdis.close();
            s.close();
        } catch (Exception e) {
            System.out.println("the unknow error ofcure");
        }
    }
}