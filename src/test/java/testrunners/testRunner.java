package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",   // path to your .feature files
        glue = {"stepdefinitions", "hooks"},        // step definitions + hooks
        plugin = {"pretty", "html:target/cucumber-reports.html"}, //for readability, reporting
        tags = "@meow", //Uncomment this to debug a scenario. Don't forget to add @debug before the scenario at
        monochrome = true
)



public class testRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
