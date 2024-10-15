package se.oscar;

public class Main {
    public static void main(String[] args) {
        Sender sender = new Sender("oscar.tornqvist01@gmail.com", "voep gtdf sfzd pjxm");
        GUI gui = new GUI();

        while (true) {
            Email email = gui.showEmailPanel();
            if (email != null) {
                sender.sendEmail(email.getTo(), email.getSubject(), email.getMessage());
                System.out.println("Sending email. . .");
            } else {
                break;
            }
        }

    }
}