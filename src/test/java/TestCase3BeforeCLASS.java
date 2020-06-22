import org.testng.Assert;
import org.testng.annotations.*;


public class TestCase3BeforeCLASS {

    @BeforeClass
    void beforeClass(){
        //executes once before starting the class
        System.out.println("This is running before class...");
    }
    @AfterClass
    void afterClass(){
        //executes once after starting the class
        System.out.println("This is running after class...");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("This is running before each tests");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("This is running after each tests");
    }

    @Test(priority = 0)
    void setUp(){
        System.out.println("Opening test1...");
    }

    @Test(priority = 1)
    void searchCustomer(){
        System.out.println("Opening test2...");
    }

    @Test(priority = 2)
    void addCustomer(){
        System.out.println("Opening test3...");
    }

    @Test(priority = 3)
    void tearDown(){
        System.out.println("Opening test4...");
    }

}
