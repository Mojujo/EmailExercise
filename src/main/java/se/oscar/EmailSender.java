package se.oscar;

public interface EmailSender {
    public void sendEmail(String to, String subject, String message);

    public void sendEmail(String to, String subject, String message, String cc);
}
