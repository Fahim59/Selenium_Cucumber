package Framework.stepDef;

import com.github.javafaker.Faker;
import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import pages.BasePage;
import pages.PageFactoryManager;
import utils.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AccountDefinition {
    public WebDriver driver;
    private final AccountPage accountPage;

    private static Faker faker = new Faker();

    String name = faker.name().firstName();
    String password = faker.internet().password();
    String email = name.toLowerCase() + "@gmail.com";

    private static final Logger logger = LogManager.getLogger(StoreDefinition.class);

    public static void main(String[] args) { Configurator.initialize(null, "log4j2.xml"); }

    public AccountDefinition(TestContext context) {
        driver = context.driver;
        accountPage = PageFactoryManager.getAccountPage(context.driver);
    }

    @And("I'm on the Account Page")
    public void iMOnTheAccountPage() throws InterruptedException {
        accountPage.clickAccountLink();

        BasePage.Scroll_Down();

        logger.info("I'm on the Account Page");
    }

    @Then("I fill up my information")
    public void iFillUpMyInformation() {
        System.out.println(name);
        System.out.println(password);
        System.out.println(email);
        accountPage.setRegistrationDetails(name,password,email);

        accountPage.clickRegisterBtn();

        logger.info("I fill up my information");
    }

    @And("Registration should be successful and I should see my username")
    public void registrationShouldBeSuccessfulAndIShouldSeeMyUsername() throws InterruptedException {
        BasePage.SmallWait(1500);

        Assert.assertEquals("Hello "+name+ " (not "+name+"? Log out)", accountPage.text());

        logger.info("I see dashboard containing my username");
    }

    @Then("I enter my login credentials from given sheetname {string} and rownumber {int}")
    public void iEnterMyLoginCredentialsFromGivenSheetnameAndRownumberRowNumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException, InterruptedException {
        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData =
                reader.getData("E:\\Intellij Files\\Excel Files\\AskOmDch.xlsx", sheetName);

        String username = testData.get(rowNumber).get("User Name");
        String password = testData.get(rowNumber).get("Password");

        System.out.println("Username is: "+username);
        System.out.println("Password is: "+password);

        accountPage.enterLoginDetails(username,password);
        accountPage.clickLoginBtn();

        BasePage.Scroll_Down();

        logger.info("I enter my login credentials");
    }

    @And("Login should be successful and username should be visible from given sheetname {string} and rownumber {int}")
    public void loginShouldBeSuccessfulAndUsernameShouldBeVisibleFromGivenSheetnameAndRownumberRowNumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData =
                reader.getData("E:\\Intellij Files\\Excel Files\\AskOmDch.xlsx", sheetName);

        String username = testData.get(rowNumber).get("User Name");

        Assert.assertEquals("Hello "+username+ " (not "+username+"? Log out)", accountPage.text());

        logger.info("Login is successful");
    }
}
