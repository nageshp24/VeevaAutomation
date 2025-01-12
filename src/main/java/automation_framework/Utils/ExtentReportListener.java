package automation_framework.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.*;

import java.io.File;
import java.io.IOException;

import static automation_framework.Utils.FileUtils.*;

public class ExtentReportListener implements ITestListener {

    private ExtentReports extentReports;
    private ExtentTest extentTest;
    private ExtentHtmlReporter htmlReporter;

    // This will run before the test suite starts
    @Override
    public void onStart(ITestContext context) {
        // Create an object of ExtentReports
        htmlReporter = new ExtentHtmlReporter("target/ExtentReports/ExtentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    // This will run before each test method
    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
    }

    // This will run if the test passes
    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.pass("Test Passed");
    }

    // This will run if the test fails
    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.fail("Test Failed: " + result.getThrowable().getMessage());
    }

    // This will run after all the tests finish
    @Override
    public void onFinish(ITestContext context) {
        // Attach the text file to the report
        String filePath = "src/Output/DP2_LinksFile.csv"; // Specify the path to your text file
        File file = new File(filePath);

        if (file.exists()) {
            // Attach the file to the report (use your report folder as destination)
            String reportFilePath = "target/ExtentReports/attachments/DP2_LinksFile.csv";
            FileUtils.copyFile(file, new File(reportFilePath));
            extentTest.addScreenCaptureFromPath(reportFilePath);  // Attach the file as an image (text file in this case)
        } else {
            extentTest.info("Text file not found at path: " + filePath);
        }
        extentReports.flush();  // Write the results to the HTML report
    }

    // Other overridden methods from ITestListener are optional
    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.skip("Test Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }


}

