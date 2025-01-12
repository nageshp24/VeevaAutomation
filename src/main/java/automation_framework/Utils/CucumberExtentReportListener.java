package automation_framework.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberExtentReportListener {

    private static ExtentReports extentReports;
    private static ExtentTest extentTest;
    private static ExtentHtmlReporter htmlReporter;

    @Before
    public void setUp() {
        htmlReporter = new ExtentHtmlReporter("target/ExtentReports/CucumberExtentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        extentTest = extentReports.createTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            extentTest.fail("Scenario Failed: " + scenario.getName());
        } else {
            extentTest.pass("Scenario Passed: " + scenario.getName());
        }
        extentReports.flush();
    }
}

