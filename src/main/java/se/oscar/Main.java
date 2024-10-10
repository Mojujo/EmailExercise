package se.oscar;

public class Main {
    public static void main(String[] args) {
        Sender sender = new Sender("oscar.tornqvist01@gmail.com", "voep gtdf sfzd pjxm");

        sender.sendEmail("oscar.tornqvist@stud.sti.se", "Test", "Detta är ett test.");
    }
}