import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableDisplay {
    public static void main(String[] args) {
        // Define data for JTable
        Object[][] data = {
                { "John", "Doe", "30" },
                { "Jane", "Smith", "25" },
                { "Mike", "Johnson", "40" }
        };

        // Define column names
        String[] columnNames = { "First Name", "Last Name", "Age" };

        // Create table model and JTable
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);

        // Create and set up the window
        JFrame frame = new JFrame("2D Array Display with JTable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table));
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
