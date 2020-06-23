import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersSamples {

    WebDriver driver;
    String driverPath = "./geckodriver";
    String driverPathChrome = "./chromedriver";

    @BeforeClass
    @Parameters({"browser", "url"})
    void setUp(String browser, String app){
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", driverPathChrome);
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
        }
        driver.get(app);
    }

    @Test(priority = 0)
    void logoTest(){
        WebElement logo = driver.findElement(By.id("hplogo"));
        Assert.assertTrue(logo.isDisplayed(), "Logo not displayed on the page...");
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
