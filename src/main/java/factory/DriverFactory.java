package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     * This method is used to initialize the thread local driver on the basis of given
     * browser
     *
     * @param browser
     * @return this will return tldriver.
     */

//    public WebDriver initializeDriver(String browser) {
//
//        System.out.println("browser value is: " + browser);
//
//        if(browser.equalsIgnoreCase("chrome")){
//            WebDriverManager.chromedriver().setup();
//            //driver = new ChromeDriver();
//            tlDriver.set(new ChromeDriver());
//            getDriver().manage().window().maximize();
//        }
//        else if(browser.equalsIgnoreCase("firefox")){
//            WebDriverManager.firefoxdriver().setup();
//            //driver = new FirefoxDriver();
//            tlDriver.set(new FirefoxDriver());
//        }
//        else{
//            System.out.println("INVALID BROWSER" +browser);
//        }
//
//        getDriver().manage().deleteAllCookies();
//        return getDriver();
//    }

    public static WebDriver initializeDriver(String browser){
        System.out.println("browser value is: " + browser);

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                tlDriver.set(new ChromeDriver());
                getDriver().manage().window().maximize();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                tlDriver.set(new FirefoxDriver());
                break;

            default: throw new IllegalStateException("INVALID BROWSER" +browser);
        }

        getDriver().manage().deleteAllCookies();
        return getDriver();
    }

    /**
     * this is used to get the driver with ThreadLocal
     *
     * @return
     */

    public static WebDriver getDriver() {
        return tlDriver.get();
    }
}