package Core_Product_Tests.StepDefinitions;

import Core_Product_Tests.Pages.Core_Product_HomePage;
import Core_Product_Tests.Pages.Core_Product_MensPage;
import automation_framework.DriverUtils.SetupDriver;
import automation_framework.Utils.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Map;


public class TestCase1_Steps {

    WebDriver driver= SetupDriver.getDriver("firefox");
    Logger logger=null;
    @Before
    public void setUp()
    {
           logger = LoggerUtil.getLogger();
    }
    Core_Product_HomePage HomePage=new Core_Product_HomePage(driver);
    // Going to home page
    @Given("user on the CP home page")
    public void user_on_the_cp_home_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.nba.com/warriors");
        driver.manage().window().maximize();
        HomePage.ClosedialogWindow();
        logger.info("user on the CP home page");

    }
    // Navigating to Mens jackets
    @When("user navigate to the Shop Menu and select Men's Jackets")
    public void user_navigate_to_the_shop_menu_and_select_men_s_jackets() throws InterruptedException {
        //wait

        //Navigate to shop
        Core_Product_HomePage HomePage=new Core_Product_HomePage(driver);
        CommonUtils.staticWait();
        HomePage.hoverOverShopMenu();
        logger.info("user navigate to the Shop Menu");
        //Click on Mens menu
        HomePage.clickMensMenu();
        logger.info("select Men's Jackets");
    }
    // Store thedata to text file
    @Then("user store each Jacket Price, Title and Top Seller message to a text file")
    public void user_store_each_jacket_price_title_and_top_seller_message_to_a_text_file() throws InterruptedException {
        Core_Product_MensPage MensPage=new Core_Product_MensPage(driver);
        CommonUtils.staticWait();
        CommonUtils.staticWait();

        Map<String,String> productDetails=MensPage.getProductDetails();
        FileUtils.writeToFile(productDetails.toString());
        logger.info("user store each Jacket Price, Title and Top Seller message to a text file");
    }
    @Then("attach the text file to the report")
    public void attach_the_text_file_to_the_report() {
        // Write code here that turns the phrase above into concrete actions

        logger.info("attach the text file to the report");

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

