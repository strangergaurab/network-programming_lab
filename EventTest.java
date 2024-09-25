import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventTest extends JFrame implements ActionListener {
    private JTextField t1, t2, t3;
    JLabel l1, l2, l3;
    JButton b1, b2, b3, b4, b5;

    public EventTest() {
        super("Handling Action Event");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 150, 10));

        l1 = new JLabel("First number");
        l2 = new JLabel("Second number");
        l3 = new JLabel("Result");

        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t3.setEditable(false);

        b1 = new JButton("ADD");
        b2 = new JButton("SUBTRACT");
        b3 = new JButton("Divisionn");
        b4 = new JButton("multiplication");
        b5 = new JButton("modulus");

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

        setSize(300, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int num1 = Integer.parseInt(t1.getText());
            int num2 = Integer.parseInt(t2.getText());
            int result = 0;

            if (e.getSource() == b1) {
                result = num1 + num2;
            } else if (e.getSource() == b2) {
                result = num1 - num2;
            } else if (e.getSource() == b3) {
                result = num1 / num2;
            } else if (e.getSource() == b4) {
                result = num1 * num2;
            } else if (e.getSource() == b5) {
                result = num1 % num2;
            }

            t3.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            t3.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        new EventTest();
    }
}
