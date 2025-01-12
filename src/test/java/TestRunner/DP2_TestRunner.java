package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/resources/Derived_Product2_Tests/TestCase4.feature",
        glue = "Derived_Product2_Tests.StepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true

)
public class DP2_TestRunner extends AbstractTestNGCucumberTests {
//
//    @BeforeClass(alwaysRun = true)
//    @Parameters("cucumber.tags")
//    public void setCucumberTags(@Optional("") String tags) {
//        System.setProperty("cucumber.filter.tags", tags);
//    }
}
