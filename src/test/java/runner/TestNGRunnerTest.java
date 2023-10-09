package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
       //plugin = {"pretty","html:target/cucumber.html"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun = false,
        monochrome = true,
        glue = {"stepDef","hooks"},
        features = "src/test/resources/features",
        tags = "@smoke"
)
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {

}
