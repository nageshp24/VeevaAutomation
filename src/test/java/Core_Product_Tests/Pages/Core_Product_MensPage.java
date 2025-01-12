package Core_Product_Tests.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Core_Product_MensPage {
    private WebDriver driver;





    @FindBy(xpath = "//*[@class='column']//div[@class='product-card-title']/a")
    private List<WebElement> productTitles;

    @FindBy(xpath = "//*[@class='column']//span[@class='sr-only']")
    private List<WebElement> productPrices;


    // Constructor
    public Core_Product_MensPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements
    }


    // Method to get and print the titles
    public void printProductTitles() {
        for (WebElement titleElement : productTitles) {
            // Get and print the text of each product title
            System.out.println("Print Nagesh");
            String title = titleElement.getAttribute("title");
            System.out.println("Product Title: " + title);
        }
    }
    public  Map<String,String> getProductDetails() {
        String data="";
        Map<String,String> ProductDetails = new HashMap<String,String>();

            if (productTitles.size() == productPrices.size()) {
                for(int i=0;i<productPrices.size()-1;i++) {
                    String title = productTitles.get(i).getAttribute("title");
                    String price = productPrices.get(i).getAttribute("title");
                    ProductDetails.put(title,price);
                }
            } else {
                System.out.println("Error: Mismatch in the size of product titles and prices.");
            }

        return ProductDetails;

    }





    public void  ClosedialogWindow() {
        Actions actions = new Actions(driver);
        // Move the mouse to (100, 100) coordinates and click
        actions.moveByOffset(100, 100).click().perform();
    }



}



