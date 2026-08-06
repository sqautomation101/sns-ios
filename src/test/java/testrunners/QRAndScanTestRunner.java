package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features/QRAndScan.feature",   // path to your .feature files
        glue = {"stepdefinitions", "hooks"},        // step definitions + hooks
        plugin = {"pretty",
                "json:target/cucumber-json/initial/qrandscan.json", //Machine-readable, for merging reports, rerun handling, and CI dashboards.
                "rerun:target/rerun-txt/initial/rerun-qrscan.txt"   // <-- automatically logs failed scenarios
                ,
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true
)


public class QRAndScanTestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}