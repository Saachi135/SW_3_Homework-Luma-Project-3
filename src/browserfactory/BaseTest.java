package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;     // web driver given object

    public void openBrowser(String baseUrl) {
        // set chromedriver
        driver = new ChromeDriver();
        //set base url
        driver.get(baseUrl);
        // window maximize
        driver.manage().window().maximize();
        // window implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    public void closeBrowser(){
        // close browser
        driver.quit();
    }
}
