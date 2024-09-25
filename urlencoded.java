import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class urlencoded {
    public static void main(String[] args) {
        try {
            String originalString = "name=John Doe&occupation=Software Developer";

            String encodedString = URLEncoder.encode(originalString, "UTF-8");

            System.out.println("Original String: " + originalString);
            System.out.println("Encoded String: " + encodedString);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error encoding the string.");
        }
    }
}
