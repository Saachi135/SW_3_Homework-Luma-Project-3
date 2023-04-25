package Utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;

import java.time.Duration;

public class Utility extends BaseTest {


   // This method will click on element
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }
    //This method will send text to element
         public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    // This method will get text from element

    public String getTextFromElement(By by){
        return driver.findElement(by).getText();

    }
    public void getElement (By by){
        driver.findElement(by);

    }
    public void waitTime(int a) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(a));
    }

//    public void compareElement(By by) {
//        Assert.assertEquals("Text not matching", expectedMessage, actualMessage);
//}
}