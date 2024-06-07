package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

/**
 *  * Create the package utilities and create the class with the name ‘Utility’ inside the ‘utilities’
 *  * package. And write the all the utility methods in it’.
 *  *
 */
public class Utility extends BaseTest {
    //This method send text on element
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //This method will send text to element
    public void sendTextToElement(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }

    // This method will get text from element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
        // actions.moveToElement(driver.findElement(by)).moveToElement(driver.findElement(by1)).click().build().perform();
    }

}
