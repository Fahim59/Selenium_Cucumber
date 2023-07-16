package pages;

import factory.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import utils.ConfigLoader;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Base64;
import java.util.Properties;

public class BasePage {

    public static void Open_Website(String endPoint){
        DriverFactory.getDriver().get(new ConfigLoader().initializeProperty().getProperty("baseUrl") +endPoint);
    }

    public static void SmallWait(int second) throws InterruptedException {Thread.sleep(second);}

    public static void Scroll_Down() throws InterruptedException {
        SmallWait(1000);
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript("window.scrollBy(0,350)", "");
    }

    public static void SendEmail() throws InterruptedException {
        SmallWait(2000);

        String decode_pass = "aWl1bXJmdHRmd3VldGdjdQ==";
        String password = new String(Base64.getDecoder().decode(decode_pass.getBytes()));

        final String from = "testmustafizur@gmail.com"; //For Yahoo, it should be a yahoo mail

        //final String p1 = "tauhid@erainfotechbd.com";
        //final String p2 = "sbappy88@gmail.com";
        //final String p3 = "parul@erainfotechbd.com";
        final String p4 = "mrahaman59@yahoo.com";

        String host = "smtp.gmail.com"; //smtp.mail.yahoo.com
        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("testmustafizur", password);
            }
        });

        session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);
            Multipart multipartObject = new MimeMultipart();

            message.setFrom(new InternetAddress(from));

            //message.addRecipient(Message.RecipientType.BCC, new InternetAddress(p1));
            //message.addRecipient(Message.RecipientType.BCC, new InternetAddress(p2));
            //message.addRecipient(Message.RecipientType.TO, new InternetAddress(p3));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(p4));

            message.setSubject("Test Execution Result Report"); //Mail Subject

            BodyPart emailBody = new MimeBodyPart();
            emailBody.setText("Dear Sir/Ma'am, " + "\n" + "Here is test result execution report." + "\n" + "\n" + "Test Executed By-" + "\n" + "Mustafizur Rahman");

            BodyPart attachment = new MimeBodyPart();
            String filename = "C:\\Users\\Mustafizur Rahman\\Downloads\\New_Project\\Reports\\testresult.html";
            DataSource source = new FileDataSource(filename);
            attachment.setDataHandler(new DataHandler(source));
            attachment.setFileName(filename);

            multipartObject.addBodyPart(emailBody); //Mail Body
            multipartObject.addBodyPart(attachment); // Attachment

            message.setContent(multipartObject);

            System.out.println("Sending............");
            Transport.send(message);
            System.out.println("Email Sent Successfully....");
        }
        catch (MessagingException mex) {
            mex.printStackTrace();
            System.out.println("Email Sent Failed....");
        }
    }
}
