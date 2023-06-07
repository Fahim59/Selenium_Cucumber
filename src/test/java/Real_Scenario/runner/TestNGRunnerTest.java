package Real_Scenario.runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

@CucumberOptions
        (
                features = "src/test/resources/Real_Scenario",
                glue = {"Real_Scenario.stepDef","Real_Scenario.hooks"},
                plugin = {"pretty","html:target/TestNG_Cucumber.html", "summary"},
                snippets = CucumberOptions.SnippetType.CAMELCASE
                //dryRun = true,
                //monochrome = true,
                //tags = "@Sanity"
        )
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {
//        @Override
//        @DataProvider(parallel = true)
//        public Object[][] scenarios() {
//                return super.scenarios();
//        }
}