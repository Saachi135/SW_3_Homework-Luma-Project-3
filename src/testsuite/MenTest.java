package testsuite;

import Utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() {
        // Mouse Hover on Men Menu
        WebElement men = driver.findElement(By.xpath("//span[contains(text(),'Men')]"));
        // Mouse Hover on Bottoms
        WebElement bottoms = driver.findElement(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));
        // Click on Pants
        WebElement pants = driver.findElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(men).moveToElement(bottoms).moveToElement(pants).click().perform();

        //‘Cronus Yoga Pant’ and click on size
        clickOnElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        //32.
        clickOnElement(By.xpath("//div[@id='option-label-size-143-item-175']"));
        // finding element and call driver
        clickOnElement(By.xpath("//div[@id='option-label-color-93-item-49']"));
        // sort data
        clickOnElement(By.xpath("//button[@id='product-addtocart-button']"));

        // expected message
        String expectedMessage = "You added Cronus Yoga Pant to your shopping cart.";
        // Verifying web text with expected text
        String actualMessage = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals("Text not matching", expectedMessage, actualMessage);

        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.cssSelector(".message-success.success.message div a"));

        //Verify the text ‘Shopping Cart.
        Assert.assertEquals("Message not matchin", expectedMessage, actualMessage);

        //Verity the product name 'Cronus Yogo Pant'*/
        Assert.assertEquals("name doesn't match", "Cronus Yoga Pant", getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']")));

        //Verify the product colour ‘Black’*/
        Assert.assertEquals("Colour is not matched", "Black", getTextFromElement(By.xpath("//dd[contains(text(),'Black ')]")));

        //Verify the product size ‘32’*/
        Assert.assertEquals("Size is not correct", "32", getTextFromElement(By.xpath("//dd[contains(text(),'32 ')]")));

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
