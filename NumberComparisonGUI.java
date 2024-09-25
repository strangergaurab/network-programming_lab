import javax.swing.*;
import java.awt.event.*;

public class NumberComparisonGUI {
    public static void main(String[] args) {
        // Create a frame
        JFrame frame = new JFrame("Number Comparison");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create text fields for input numbers
        JTextField numField1 = new JTextField();
        JTextField numField2 = new JTextField();
        numField1.setBounds(50, 30, 80, 30);
        numField2.setBounds(150, 30, 80, 30);

        // Create a label to display the result
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(50, 100, 200, 30);

        // Add mouse listener to the frame
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    int num1 = Integer.parseInt(numField1.getText());
                    int num2 = Integer.parseInt(numField2.getText());
                    int smaller = Math.min(num1, num2);
                    resultLabel.setText("Smaller: " + smaller);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter valid numbers.");
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    int num1 = Integer.parseInt(numField1.getText());
                    int num2 = Integer.parseInt(numField2.getText());
                    int greater = Math.max(num1, num2);
                    resultLabel.setText("Greater: " + greater);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter valid numbers.");
                }
            }
        });

        // Add components to the frame
        frame.add(numField1);
        frame.add(numField2);
        frame.add(resultLabel);

        // Set frame visibility
        frame.setVisible(true);
    }
}
