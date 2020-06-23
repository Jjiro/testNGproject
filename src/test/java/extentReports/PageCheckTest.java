package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
/*import com.aventstack.extentreports.reporter.ExtentHtmlReporter;*/  //Deprecated
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PageCheckTest {

    public WebDriver driver;
    public String driverPath = "./geckodriver";

    public ExtentSparkReporter extentSparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    @BeforeTest
    public void setExtent(){
        extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/myReport.html");

        extentSparkReporter.config().setDocumentTitle("Automation Report");
        extentSparkReporter.config().setReportName("Functional Report");
        extentSparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(extentSparkReporter);

        extent.setSystemInfo("Hostname", "LocalHost");
        extent.setSystemInfo("OS", "MacOS");
        extent.setSystemInfo("Tester Name", "Jane");
        extent.setSystemInfo("Browser", "Chrome");
    }

    @AfterTest
    void endReport(){
        extent.flush();
    }


    @BeforeMethod
    void setUp(){
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.pramp.com/#/");
    }

    @Test
    void prampTitleTest() throws InterruptedException {
        test = extent.createTest("prampTitleTest");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("Pramp", "Pramp");
        System.out.println(driver.getTitle());
    }

    @Test
    void prampLogoTest() throws InterruptedException {
        test = extent.createTest("prampLogoTest");
        /*System.setProperty("webdriver.gecko.driver", "./geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://www.pramp.com/#/");*/
        Boolean status = driver.findElement(By.className("companylogo")).isDisplayed();
        Assert.assertTrue(status, "Logo not displayed on the page...");
        Thread.sleep(3000);
    }

    @Test
    void prampLoginTest() throws InterruptedException {
        test = extent.createTest("prampLoginTest");
        /*System.setProperty("webdriver.gecko.driver", "./geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://www.pramp.com/#/");*/
        driver.findElement(By.cssSelector("a[href='/#/sign-in']")).click();
        driver.findElement(By.name("email")).sendKeys("jane@doe.com");
        driver.findElement(By.name("password")).sendKeys("Admin123");
        driver.findElement(By.className("auth-button")).click();
        String errorMessage = driver.findElement(By.className("bubble-error-component")).getText();
        Assert.assertEquals(errorMessage,"The email or password you entered is incorrect", "Please enter a correct email and/or password...");
    }


    public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
        String dateName = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File fileSource = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String destination = System.getProperty("user.dir") + "Screenshots/" + screenshotName + dateName + ".png";
        File fileFinalDestination = new File(destination);
        FileUtils.copyFile(fileSource, fileFinalDestination);
        return destination;
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE){
            test.log(Status.FAIL, "THIS TEST CASE FAILED... " + result.getName()); //adds name to extent report
            test.log(Status.FAIL, "THIS TEST CASE FAILED... " + result.getThrowable()); //adds exceptions to extent report
            String screenshotPath = PageCheckTest.getScreenshot(driver, result.getName()); //get screenshot and add to path
            test.addScreenCaptureFromPath(screenshotPath); //add screenshot to extend report
        }else if(result.getStatus() == ITestResult.SKIP){
            test.log(Status.SKIP, "THIS TEST CASE SKIPPED... " + result.getName());
        }else if(result.getStatus() == ITestResult.SUCCESS){
            test.log(Status.PASS, "THIS TEST CASE PASSED... " + result.getName());
        }
        driver.quit();
    }

}
