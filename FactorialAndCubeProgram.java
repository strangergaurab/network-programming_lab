import javax.swing.*;
import java.awt.event.*;

public class FactorialAndCubeProgram extends JFrame implements MouseListener {
    private JLabel inputLabel, outputLabel;
    private JTextField inputTextField;
    private JButton resultButton;

    public FactorialAndCubeProgram() {
        setTitle("Factorial and Cube Program");
        setSize(400, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputLabel = new JLabel("Enter a number:");
        inputLabel.setBounds(50, 30, 100, 20);
        add(inputLabel);

        inputTextField = new JTextField();
        inputTextField.setBounds(150, 30, 100, 20);
        add(inputTextField);

        resultButton = new JButton("Result");
        resultButton.setBounds(100, 80, 100, 30);
        resultButton.addMouseListener(this);
        add(resultButton);

        outputLabel = new JLabel();
        outputLabel.setBounds(100, 130, 200, 20);
        add(outputLabel);

        setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == resultButton) {
            int num = Integer.parseInt(inputTextField.getText());
            int fact = 1;
            for (int i = 1; i <= num; i++) {
                fact *= i;
            }
            outputLabel.setText("Factorial of " + num + " is " + fact);
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == resultButton) {
            int num = Integer.parseInt(inputTextField.getText());
            int cube = num * num * num;
            outputLabel.setText("Cube of " + num + " is " + cube);
        }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public static void main(String[] args) {
        new FactorialAndCubeProgram();
    }
}