
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.*;

import javax.swing.JFrame;

public class EventTests extends JFrame implements TextListener {
    TextField t;
    Label l;

    public EventTests() {
        setTitle("Handling text Event");
        setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));
        t = new TextField(200);
        l = new Label("Handling text event");
        add(t);
        add(l);
        t.addTextListener(this);
        setSize(400, 300);
        setVisible(true);
    }

    public void textValueChanged(TextEvent te) {
        if (te.getSource() == t) {
            String msg = "YOur Types" + t.getText();
            l.setText(msg);
        }
    }

    public static void main(String[] args) {
        new EventTests();
    }
}
