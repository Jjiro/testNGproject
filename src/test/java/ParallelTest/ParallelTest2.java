package ParallelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ParallelTest2 {

    WebDriver driver;

    @Test
    void loginTest() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "./geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page");
        driver.findElement(By.id("wpName1")).sendKeys("Admin");
        driver.findElement(By.id("wpPassword1")).sendKeys("Admin123");
        driver.findElement(By.id("wpLoginAttempt")).click();

        Assert.assertEquals(driver.getTitle(),"Log in - Wikipedia", "Title not displayed...");
        Thread.sleep(3000);
    }


    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
