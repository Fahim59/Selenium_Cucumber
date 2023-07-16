package Framework.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions
        (
                features = "src/test/resources/Framework",
                glue = {"Framework.stepDef","Framework.hooks"},
                plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                        "rerun:target/Failed_Scenario/failedscenarios.txt", "utils.ExcelPlugin"},

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