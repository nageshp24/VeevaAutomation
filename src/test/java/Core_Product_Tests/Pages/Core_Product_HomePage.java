package Core_Product_Tests.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Core_Product_HomePage {
    private WebDriver driver;


    @FindBy(xpath = "//a[@class='accent-primary-border _link_ob2qz_1 text-2sm']/span[text()='Shop']")
    private WebElement shopMenu;

    @FindBy(xpath = "//*[@id=\"nav-dropdown-desktop-1059653\"]/li/a[contains(text(),'Men')]")
    private WebElement mensMenu;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div")
    private WebElement dialogWindowClose;

    @FindBy(xpath = "//iframe[@id='_hjSafeContext_62946833']")
    private WebElement dialogWindowFrame;

    // Constructor
    public Core_Product_HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements
    }

    // Actions
    public void hoverOverShopMenu() {
        Actions actions = new Actions(driver);
        actions.moveToElement(shopMenu).perform();
    }
    public void  clickMensMenu() {
        mensMenu.click();
    }




    public void  ClosedialogWindow() {
        Actions actions = new Actions(driver);
        // Move the mouse to (100, 100) coordinates and click
        actions.moveByOffset(100, 100).click().perform();
    }



}

