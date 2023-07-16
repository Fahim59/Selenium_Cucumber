package Framework.hooks;

import factory.DriverFactory;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utils.ConfigLoader;

import java.io.File;
import java.io.IOException;

public class MyHooks {
    private static WebDriver driver;

    public static void saveLogFile() {
        try {
            File logFile = new File("Log Result/test.log");
            File outputFile = new File("Log Result/test_output.txt");

            String logContents = FileUtils.readFileToString(logFile, "UTF-8");
            FileUtils.writeStringToFile(outputFile, logContents, "UTF-8");
        }
        catch (Exception e) {
            System.out.println("Log save failed" +e);
        }
    }

    @Before()
    public void launch_browser(Scenario scenario) {
        System.out.println("Before Thread ID: " +Thread.currentThread().getId() +","+ "Scenario Name: " +scenario.getName());

        driver = DriverFactory.initializeDriver(System.getProperty("browser",
                new ConfigLoader().initializeProperty().getProperty("browser")));
    }

    @AfterStep
    public static void Screenshoot(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            String screenshotName = scenario.getName().replaceAll(" ", "_");

            File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "github");

            File destinationPath = new File("target/Failed_Scenario/FailedScreenshots/" + screenshotName + ".jpg");
            FileUtils.copyFile(image, destinationPath);
        }
    }

    @After
    public void quitBrowser(Scenario scenario) throws InterruptedException {
        System.out.println("After Thread ID: " +Thread.currentThread().getId() +","+ "Scenario Name: " +scenario.getName());
        saveLogFile();
        driver.quit();
    }
}
