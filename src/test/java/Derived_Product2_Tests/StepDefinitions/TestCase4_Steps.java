package Derived_Product2_Tests.StepDefinitions;

import Derived_Product2_Tests.Pages.Derived_Product2_HomePage;
import automation_framework.DriverUtils.SetupDriver;
import automation_framework.Utils.CommonUtils;
import automation_framework.Utils.FileUtils;
import automation_framework.Utils.LoggerUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;


import java.util.Map;


public class TestCase4_Steps {

    WebDriver driver= SetupDriver.getDriver("firefox");

    Logger logger=null;
    @Before
    public void setUp()
    {
        logger = LoggerUtil.getLogger();
    }

    Derived_Product2_HomePage HomePage=new Derived_Product2_HomePage(driver);
    // Dp2 Hoem page
    @Given("User on the DP2 home page")
    public void user_on_the_dp2_home_page() {
        driver.get("https://www.nba.com/bulls");
        driver.manage().window().maximize();
        logger.info("User on the DP2 home page");
    }
    // Going end of the page
    @When("User scroll down to the footer")
    public void user_scroll_down_to_the_footer() throws InterruptedException {
        CommonUtils.staticWait();
        HomePage.Scrooldown();
        CommonUtils.staticWait();
        logger.info("User scroll down to the footer");

    }
    // Store links to csv
    @Then("User find all footer hyperlinks and store them in a CSV file report if any duplicate hyperlinks are present")
    public void user_find_all_footer_hyperlinks_and_store_them_in_a_csv_file() {
        Map<String, Integer> Alllinks=HomePage.getAllLinks_FindDuplicateLinks();
        FileUtils.writeToCSVFile( Alllinks.keySet().toString());
        logger.info("store hyperlinks in a CSV file report if any duplicate hyperlinks are present");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @AfterTest
    public void tearDown1() {
        driver.quit();
    }


}

