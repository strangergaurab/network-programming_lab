import java.awt.*;
import javax.swing.*;

public class GridLayoutDemo extends JFrame {
    static final int n = 4;

    public GridLayoutDemo() {
        setLayout(new GridLayout(n, n));
        setFont(new Font("SansSerif", Font.BOLD, 24));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = i * n + j;
                if (k > 0)
                    add(new Button("" + k));
            }
        }
    }

    public static void main(String[] args) {
        GridLayoutDemo obj = new GridLayoutDemo();
        obj.setSize(300, 300);
        obj.setVisible(true);
    }
}