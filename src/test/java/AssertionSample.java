import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssertionSample {

    WebDriver driver;
    String driverPath = "./geckodriver";
    String driverPathChrome = "./chromedriver";

    @BeforeClass
    void setUp(){
        /*System.setProperty("webdriver.gecko.driver", driverPath);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("marionette", true);
        driver = new FirefoxDriver(firefoxOptions);*/
        System.setProperty("webdriver.chrome.driver", driverPathChrome);
        driver = new ChromeDriver();
        driver.get("https://google.com/ncr");
    }

    @Test(priority = 0)
    void logoTest(){
        WebElement logo = driver.findElement(By.id("hplogo"));
        //Assert.assertTrue(logo.isDisplayed(), "Logo not displayed on the page...");
        Assert.assertFalse(logo.isDisplayed(), "Logo displayed on the page...");
    }

    @Test(priority = 1)
    void homepageTitle(){
        String title = driver.getTitle();
        Assert.assertEquals("Google", title, "Title not matching...");
        System.out.println(title);
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
