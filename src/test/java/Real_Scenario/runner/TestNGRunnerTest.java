package Real_Scenario.runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

@CucumberOptions
        (
                features = "src/test/resources/Real_Scenario",
                glue = {"Real_Scenario.stepDef","Real_Scenario.hooks"},
                plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                        "rerun:target/Failed_Scenario/failedscenarios.txt"},
                snippets = CucumberOptions.SnippetType.CAMELCASE
                //dryRun = true,
                //monochrome = true,
                //tags = "@Sanity"
        )
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}