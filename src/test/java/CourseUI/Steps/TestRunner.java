package CourseUI.Steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/pogoda.feature",
        glue = "CourseUI/Steps")
public class TestRunner {
    @BeforeClass
    public static void setup() {
        String driverPath = System.getProperty("user.dir") + "\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
    }
}