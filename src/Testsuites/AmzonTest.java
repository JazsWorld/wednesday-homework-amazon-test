package Testsuites;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 * Automate Following Test.
 * 1. Open the URL https://www.amazon.co.uk/
 * 2. Type "Dell Laptop" in the search box and press enter or click on search
 *    Button.
 * 3. Click on the checkbox brand Dell on the left side.
 * 4. Verify that the  30(May be different) products are displayed on the page.
 * 5. Print all product names in the console.
 * 6. Click on the product name 'Dell Latitude 5410 14" FHD Business Laptop Computer, Intel Core i5-10310U, 16GB RAM, 512GB SSD, Backlit Keyboard, Windows 10 Pro (Renewed)'
 * 7. Verify the Product name 'Dell Latitude 5410 14" FHD Business Laptop Computer, Intel Core i5-10310U, 16GB RAM, 512GB SSD, Backlit Keyboard, Windows 10 Pro (Renewed)'
 * 5. Close the Browser.
 */

public class AmzonTest extends Utility {
    //* 1. Open the URL https://www.amazon.co.uk/
    String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void typeDellLaptopintheSearchBoxandPressEnterOrClickonSearch() {

        clickOnElement(By.id("sp-cc-accept"));
        // * 2. Type "Dell Laptop" in the search box and
        sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"), "Dell Laptop");

        // * 2. press enter or click on search Button.
        clickOnElement(By.xpath("//input[@id='nav-search-submit-button']"));

        //* 3. Click on the checkbox brand Dell on the left side.
        clickOnElement(By.xpath("//li[@id='p_89/Dell']//i[@class='a-icon a-icon-checkbox']"));

        //* 4. Verify that the  30(May be different) products are displayed on the page.
        int expectedQty = 30;
        List<WebElement> productList = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
        int actualQty = productList.size();
        Assert.assertEquals("Product QTY does not match", expectedQty, actualQty);

        //5. Print all product names in the console.
        List<WebElement> productNames = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        int size = productNames.size();
        System.out.println("Total number of " + size);
        for (WebElement e : productNames) {
            System.out.println(e.getText());
        }


        //* 6. Click on the product name 'Dell Latitude 5410 14" FHD Business Laptop Computer, Intel Core i5-10310U, 16GB RAM, 512GB SSD, Backlit Keyboard, Windows 10 Pro (Renewed)'
        mouseHoverToElementAndClick(By.xpath("//span[normalize-space()='Dell Latitude 7490 Laptop Windows 11 Pro - 14\" Full HD (1920x1080) Quad Core i5-8350U 16GB DDR4 256GB SSD HDMI USB-C WiFi WebCam (Renewed)']"));


        //* 7. Verify the Product name 'Dell Latitude 5410 14" FHD Business Laptop Computer, Intel Core i5-10310U, 16GB RAM, 512GB SSD, Backlit Keyboard, Windows 10 Pro (Renewed)'
        String expectedText = "Dell Latitude 7490 Laptop Windows 11 Pro - 14\" Full HD (1920x1080) Quad Core i5-8350U 16GB DDR4 256GB SSD HDMI USB-C WiFi WebCam (Renewed)";
        String actualText = driver.findElement(By.xpath("//span[contains(text(),'Dell Latitude 7490 Laptop Windows 11 Pro - 14\" Ful')]")).getText();
        Assert.assertEquals(expectedText, actualText);
    }
    @After
    public void tearDown() {            //Close the browser
        closeBrowser();
    }
    }

