package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import page.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        /*plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                    "json:target/cucumber-reports.json"},*/
        plugin = { "pretty", "html:target/cucumber-reports"},
        monochrome = true,
        tags = "@Regression"
)

public class runner {

    @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }
}
