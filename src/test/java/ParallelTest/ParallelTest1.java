package ParallelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ParallelTest1 {

    WebDriver driver;

    @Test
    void logoTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./chromedriver");
        driver = new ChromeDriver();
        driver.get("https://google.com/ncr");
        WebElement logo = driver.findElement(By.id("hplogo"));
        Assert.assertTrue(logo.isDisplayed(), "Logo not displayed on the page...");
        Thread.sleep(3000);
    }

    @Test
    void homepageTitle() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./chromedriver");
        driver = new ChromeDriver();
        driver.get("https://google.com/ncr");
        Assert.assertEquals("Google", "Google");
        System.out.println(driver.getTitle());
        Thread.sleep(5000);
    }

    @AfterTest
    void tearDown(){
        driver.quit();
    }
}
