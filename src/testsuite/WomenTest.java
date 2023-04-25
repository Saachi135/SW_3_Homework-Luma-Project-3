package testsuite;

import Utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WomenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void verifyTheSortByProductNameFilter() {
        WebElement women = driver.findElement(By.xpath("//a[@id='ui-id-4']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
        WebElement top = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
        WebElement jackets = driver.findElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(women).moveToElement(top).moveToElement(jackets).click().perform();


        WebElement sortBy = driver.findElement(By.id("sorter"));
        Select select = new Select(sortBy);
        select.selectByVisibleText("Position");
        select.selectByVisibleText("Product Name");

        List<WebElement> productName = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
        //System.out.println(productName.size());
        for (WebElement result : productName) {
            System.out.println(result.getText());
        }
    }

    @Test
    public void verifyTheSortByPriceFilter() {
        WebElement women = driver.findElement(By.xpath("//a[@id='ui-id-4']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
        WebElement top = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
        WebElement jackets = driver.findElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(women).moveToElement(top).moveToElement(jackets).click().perform();

        WebElement sortBy = driver.findElement(By.id("sorter"));
        Select select = new Select(sortBy);
        select.selectByVisibleText("Position");

        select.selectByVisibleText("Price");
        List<WebElement> price = driver.findElements(By.xpath("//div[@class = 'price-box price-final_price']"));
        for (int i = 0; i < price.size(); i++) {
            System.out.println(price.get(i).getText());
            String exp = price.get(i).getText();
            String actual = price.get(i).getText();
            Assert.assertEquals("Price not ordered : Low to High  ", exp, actual);
        }
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}

