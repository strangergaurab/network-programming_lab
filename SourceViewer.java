import java.net.*;
import java.io.*;

public class SourceViewer {
    public static void main(String[] args) {
        if (args.length > 0) {
            InputStream in = null;
            try {
                // Open the URL for reading
                // URL u = new URL(args[0]);
                // in = u.openStream();
                // buffer the input to increase performance in = new
                BufferedInputStream(in);
                // chain the InputStream to a Reader
                // Reader r = new InputStreamReader(in);
                // int c;
                while ((c = r.read()) != -1) {
                    System.out.print((char) c);
                }
            } catch (MalformedURLException ex) {
                System.err.println(args[0] + " is not a parseable URL");
            } catch (Exception ex) {
                System.err.println(ex);
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e) { // ignore
                    }
                }
            }
        }
    }
}
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import java.io.*;

public class DialogAuthenticator extends Authenticator {
    private JDialog passwordDialog;
    private JTextField usernameField = new JTextField(20);
    private JPasswordField passwordField = new JPasswordField(20);
    private JButton okButton = new JButton("OK");
    private JButton cancelButton = new JButton("Cancel");
    private JLabel mainLabel = new JLabel("Please enter username and password: ");
    private PasswordAuthentication response = null;

    public DialogAuthenticator() {
        this("", new JFrame());
    }

    public DialogAuthenticator(String username) {
        this(username, new JFrame());
    }

    public DialogAuthenticator(JFrame parent) {
        this("", parent);
    }

    public DialogAuthenticator(String username, JFrame parent) {
        this.passwordDialog = new JDialog(parent, true);
        Container pane = passwordDialog.getContentPane();
        pane.setLayout(new GridLayout(4, 1));
        JLabel userLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");
        pane.add(mainLabel);
        JPanel p2 = new JPanel();
        p2.add(userLabel);
        p2.add(usernameField);
        usernameField.setText(username);
        pane.add(p2);
        JPanel p3 = new JPanel();
        p3.add(passwordLabel);
        p3.add(passwordField);
        pane.add(p3);
        JPanel p4 = new JPanel();
        p4.add(okButton);
        p4.add(cancelButton);
        pane.add(p4);
        passwordDialog.pack();
        ActionListener al = new OKResponse();
        okButton.addActionListener(al);
        usernameField.addActionListener(al);
        passwordField.addActionListener(al);
        cancelButton.addActionListener(new CancelResponse());
    }

    private void displayDialog() {
        System.out.println("displayDialog called");
        String prompt = this.getRequestingPrompt();
        if (prompt == null) {
            String site = this.getRequestingSite().getHostName();
            String protocol = this.getRequestingProtocol();
            int port = this.getRequestingPort();
            if (site != null && protocol != null) {
                prompt = protocol + "://" + site;
                if (port > 0)
                    prompt += ":" + port;
            } else {
                prompt = "";
            }
        }
        mainLabel.setText("Please enter username and password for " + prompt + ": ");
        passwordDialog.pack();
        passwordDialog.setVisible(true);
    }

    class OKResponse implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            passwordDialog.setVisible(false);
            char[] password = passwordField.getPassword();
            String username = usernameField.getText();
            passwordField.setText("");
            response = new PasswordAuthentication(username, password);
        }
    }

    class CancelResponse implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            passwordDialog.setVisible(false);
            passwordField.setText("");
            response = null;
        }
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        System.out.println("getPasswordAuthentication called");
        displayDialog();
        return response;
    }

    public static void main(String[] args) {
        Authenticator.setDefault(new DialogAuthenticator());
        for (String arg : args) {
            try {
                URI uri = new URI(arg);
                URL url = uri.toURL(); // Convert URI to URL
                try (InputStream in = new BufferedInputStream(url.openStream())) { // Use URL to open stream
                    Reader r = new InputStreamReader(in);
                    int c;
                    while ((c = r.read()) != -1) {
                        System.out.print((char) c);
                    }
                }
            } catch (URISyntaxException | MalformedURLException ex) {
                System.err.println(arg + " is not a parseable URL");
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
        System.exit(0); // Uncomment if needed to explicitly exit.
    }
}
