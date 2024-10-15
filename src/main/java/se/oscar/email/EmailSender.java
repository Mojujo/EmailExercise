package se.oscar.email;

public interface EmailSender {
    void sendEmail(String to, String subject, String message);

    void sendEmail(String to, String subject, String message, String cc);
}
