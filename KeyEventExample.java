import javax.swing.*;
import java.awt.event.*;

public class KeyEventExample extends JFrame implements KeyListener {

    private JTextField textField;
    private JLabel label;

    public KeyEventExample() {
        // Set up the frame
        setTitle("KeyEvent Example");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Create a text field
        textField = new JTextField();
        textField.setBounds(50, 50, 300, 30);
        textField.addKeyListener(this); // Add KeyListener to the text field
        add(textField);

        // Create a label to display key events
        label = new JLabel();
        label.setBounds(50, 100, 300, 30);
        add(label);

        setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Display key pressed information
        label.setText("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Display key released information
        label.setText("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Display key typed information
        label.setText("Key Typed: " + e.getKeyChar());
    }

    public static void main(String[] args) {
        new KeyEventExample();
    }
}
