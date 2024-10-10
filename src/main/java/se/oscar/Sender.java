package se.oscar;

import javax.mail.Message;
import javax.mail.*;
import javax.mail.Session;
import javax.mail.internet.*;
import java.util.Properties;

public class Sender implements EmailSender {

    private final String username;
    private final String password;
    private final java.util.Properties props;

    public Sender(String username, String password) {
        this.username = username;
        this.password = password;
        this.props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
    }

    @Override
    public void sendEmail(String to, String subject, String message) {
        executeSendingEmail(to, subject, message, null);
    }

    @Override
    public void sendEmail(String to, String subject, String message, String cc) {
        executeSendingEmail(to, subject, message, cc);
    }

    private void executeSendingEmail(String to, String subject, String message, String cc) {
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message email = new MimeMessage(session);
            email.setFrom(new InternetAddress(this.username));
            email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            email.setSubject(subject);
            email.setText(message);
            if (cc != null && !cc.isEmpty()) {
                email.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
            }
            Transport.send(email);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
