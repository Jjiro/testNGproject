package allureReports;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class PageCheckTest {

    public WebDriver driver;


    @BeforeClass
    void setUp(){
        //manages webdriver for variety of browsers...
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.pramp.com/#/");
    }

    @Test
    void prampTitleTest() throws InterruptedException {
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("Pramps", "Pramp");
        System.out.println(driver.getTitle());
    }

    @Test
    void prampLogoTest() throws InterruptedException {
        Boolean status = driver.findElement(By.className("companylogo")).isDisplayed();
        Assert.assertTrue(status, "Logo not displayed on the page...");
        Thread.sleep(3000);
    }

    @Test
    void prampLoginTest() throws InterruptedException {
        driver.findElement(By.cssSelector("a[href='/#/sign-in']")).click();
        driver.findElement(By.name("email")).sendKeys("jane@doe.com");
        driver.findElement(By.name("password")).sendKeys("Admin123");
        driver.findElement(By.className("auth-button")).click();
        String errorMessage = driver.findElement(By.className("bubble-error-component")).getText();
        System.out.println(errorMessage);
        Assert.assertEquals(errorMessage,"The email or password you entered is incorrect", "Please enter a correct email and/or password...");
    }

    @Test
    public void signUp(){
        throw new SkipException("Just skipping this test... ");
    }

    @AfterClass
    public void tearDown(ITestResult result) throws IOException {
        driver.quit();
    }

}
