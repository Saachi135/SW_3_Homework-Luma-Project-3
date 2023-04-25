package testsuite;

import Utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
        waitTime(20);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        //Mouse Hover on Gear Menu
        waitTime(10);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        clickOnElement(By.xpath("//span[contains(text(),'Gear')]"));
        getElement(By.xpath("//a[@id='ui-id-25']//span[contains(text(),'Bags')]"));

        ///Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));
        waitTime(10);

        //Change Qty 3
        sendTextToElement(By.xpath("//input[@id='qty']"), "3");
        waitTime(10);

        //Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//button[@id='product-addtocart-button']"));
        waitTime(10);

        //Verify the text
        Assert.assertEquals("Label does not match", "You added Overnight Duffle to your shopping cart.", getTextFromElement(By.xpath("//div[@class='message-success success message']")));

        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));


        Thread.sleep(500);

        sendTextToElement(By.cssSelector("td[class='col qty'] input[class*='input-text qty']"), Keys.DELETE + "5");
        // Click On 'Update Shopping Cart' button
        clickOnElement(By.xpath("//span[text()='Update Shopping Cart']"));
        // Verify the product price '$225.00'

        Assert.assertEquals("$225.00", By.xpath("//span[@class='cart-price']//span[@class='price'][text()='$225.00']"), "$225.00");

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}


