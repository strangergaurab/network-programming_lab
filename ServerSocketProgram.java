import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerSocketProgram {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(2430);
            Socket s = ss.accept();
            Writer out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            out.write("Hello Client");

            InputStream in = s.getInputStream();
            InputStreamReader irs = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(irs);
            br.lines().forEach(System.out::println);

            // Date now = new Date();
            // out.write(now.toString());
            // write a display server date and time
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
