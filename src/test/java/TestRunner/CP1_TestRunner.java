package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/resources/Core_Product_Tests/TestCase1.feature",
        glue = "Core_Product_Tests.StepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true

)

public class CP1_TestRunner extends AbstractTestNGCucumberTests {


//    @BeforeClass(alwaysRun = true)
//    @Parameters({"cucumber.tags"})
//    public void setCucumberTags(@Optional("") String tags) {
//
//        System.out.println("Running with tags: " + tags);
//        System.setProperty("cucumber.filter.tags", tags);
//    }
}
