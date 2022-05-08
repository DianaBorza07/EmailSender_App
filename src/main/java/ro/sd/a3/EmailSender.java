package ro.sd.a3;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class EmailSender {

    public void sendConfirmationEmail(String toAddress){

        String fromAddress = "confirmation@randevular.com";

        final String username = "25b0b37b125724";//username generated by Mailtrap
        final String password = "ae16f82f170c90";//password generated by Mailtrap

        String host = "smtp.mailtrap.io";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(fromAddress));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toAddress));

            message.setSubject("Registration Confirmation");

            message.setContent(generateStringFromTemplate(),"text/html; charset=utf-8");

            Transport.send(message);

            System.out.println("Message sent successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateStringFromTemplate(){
        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/main/resources/static/emailTemplate.html"));
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
        }
        String content = contentBuilder.toString();
        return content;
    }

    public void sendEmailTest(){
        String recipient = "dianaborza31@gmail.com";

        String sender = "confirmation@randevular.com";

        String host = "127.0.0.1";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);

        Session session = Session.getDefaultInstance(properties);

        try
        {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(sender));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            message.setSubject("Registration Confirmation");

            message.setContent(generateStringFromTemplate(),"text/html; charset=utf-8");

            Transport.send(message);

            System.out.println("Message sent successfully!");
        }
        catch (MessagingException mex)
        {
            mex.printStackTrace();
        }
    }

}