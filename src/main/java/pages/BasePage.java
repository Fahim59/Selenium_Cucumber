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
}
