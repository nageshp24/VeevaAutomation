package Derived_Product2_Tests.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Derived_Product2_HomePage {
    private WebDriver driver;


    @FindBy(xpath = "//*[@aria-labelledby='footer1']//li/a")
    private List<WebElement> TeamFooter;

    @FindBy(xpath = "//*[@aria-labelledby='footer2']//li/a")
    private List<WebElement> TicketsFooter;
    @FindBy(xpath = "//*[@aria-labelledby='footer3']//li/a")
    private List<WebElement> ShopFooter;
    @FindBy(xpath = "//*[@aria-labelledby='footer4']//li/a")
    private List<WebElement> CommunityFooter;
    @FindBy(xpath = "//*[@aria-labelledby='footer5']//li/a")
    private List<WebElement> UnitedCenterFooter;

    @FindBy(xpath = "//*[@aria-labelledby='footer6']//li/a")
    private List<WebElement> NewsFooter;

    @FindBy(xpath = "//*[@id=\"__next\"]/footer/div[2]//a")
    private List<WebElement> AllFooters;


    // Constructor
    public Derived_Product2_HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements
    }

    public String TeamFooterData() {
        String Hyperlink="";
        for(WebElement eachLink:TeamFooter)
        {
             Hyperlink =  Hyperlink+"\n"+eachLink.getAttribute("href");
        }
        return Hyperlink;
    }

    public String TicketsFooterData() {
        String Hyperlink="";
        for(WebElement eachLink:TicketsFooter)
        {
            Hyperlink =  Hyperlink+"\n"+eachLink.getAttribute("href");
        }
        return Hyperlink;
    }

    public String ShopFooterData() {
        String Hyperlink="";
        for(WebElement eachLink:ShopFooter)
        {
            Hyperlink =  Hyperlink+"\n"+eachLink.getAttribute("href");
        }
        return Hyperlink;
    }

    public String CommunityFooterData() {
        String Hyperlink="";
        for(WebElement eachLink:CommunityFooter)
        {
            Hyperlink =  Hyperlink+"\n"+eachLink.getAttribute("href");
        }
        return Hyperlink;
    }

    public String UnitedCenterFooterData() {
        String Hyperlink="";
        for(WebElement eachLink:UnitedCenterFooter)
        {
            Hyperlink =  Hyperlink+"\n"+eachLink.getAttribute("href");
        }
        return Hyperlink;
    }

    public String NewsFooterData() {
        String Hyperlink="";
        for(WebElement eachLink:NewsFooter)
        {
            Hyperlink =  Hyperlink+"\n"+eachLink.getAttribute("href");
        }
        return Hyperlink;
    }

    public void Scrooldown()
    {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> getAllLinks_FindDuplicateLinks() {

        Map<String, Integer> linkCount = new HashMap<>();

        for (WebElement link : AllFooters) {
            String url = link.getAttribute("href");
            linkCount.put(url, linkCount.getOrDefault(url, 0) + 1);
        }

        boolean hasDuplicates = false;
        for (Map.Entry<String, Integer> entry : linkCount.entrySet()) {
            if (entry.getValue() > 1) {
                hasDuplicates = true;
                System.out.println("Duplicate Link Found: " + entry.getKey());
            }
        }

        Assert.assertFalse(hasDuplicates, "Duplicate hyperlinks are present in the footer!");
        return linkCount;
    }


}

