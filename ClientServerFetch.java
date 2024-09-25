import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientServerFetch {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 2430);
            InputStream in = s.getInputStream();
            InputStreamReader irs = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(irs);
            br.lines().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("erro in processing");
        }

    }
}
