package se.oscar.email;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private final JPanel emailPanel;
    private final JTextField textField1;
    private final JTextField textField2;
    private final JTextField textField3;

    private ImageIcon createImage() {
        Image iconURL = Toolkit.getDefaultToolkit().getImage("src/main/resources/cats-icon.png");
        if (iconURL != null) {
            Image scaledURL = iconURL.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledURL);
        } else {
            System.out.println("Couldn't find file");
            return null;
        }
    }

    public GUI() {
        textField1 = new JTextField(20);
        textField2 = new JTextField(20);
        textField3 = new JTextField(20);

        JLabel label1 = new JLabel("Send Address: ");
        JLabel label2 = new JLabel("Subject: ");
        JLabel label3 = new JLabel("Message: ");

        emailPanel = new JPanel(new GridLayout(4, 4));
        emailPanel.add(label1);
        emailPanel.add(textField1);
        emailPanel.add(label2);
        emailPanel.add(textField2);
        emailPanel.add(label3);
        emailPanel.add(textField3);
        emailPanel.add(Box.createHorizontalStrut(5));
    }

    public Email showEmailPanel() {
        ImageIcon icon = createImage();
        int result = JOptionPane.showConfirmDialog(null, emailPanel, "Send Email", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, icon);
        if (result == JOptionPane.OK_OPTION) {
            String mailAddress = textField1.getText();
            String subject = textField2.getText();
            String message = textField3.getText();

            textField1.setText("");
            textField2.setText("");
            textField3.setText("");

            return new Email(mailAddress, subject, message);
        }
        return null;
    }
}
