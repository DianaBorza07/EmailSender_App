package ro.sd.a3;

public class Assignment3SdApplication {
    public static void main(String[] args) {
        EmailSender emailSender = new EmailSender();
        emailSender.sendConfirmationEmail("diana@mail.com");
        //emailSender.sendEmailTest();
    }
}
