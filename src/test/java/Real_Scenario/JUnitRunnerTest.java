package Real_Scenario;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                plugin = {"pretty","html:target/JUnit_Cucumber.json"}
        )
public class JUnitRunnerTest {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("\nBEFORE CLASS\n");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("\nAFTER CLASS\n");
    }
}
