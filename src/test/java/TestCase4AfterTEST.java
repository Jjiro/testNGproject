import org.testng.Assert;
import org.testng.annotations.*;


public class TestCase4AfterTEST {



    @BeforeSuite
    void beforeSuite(){
        //executes once before suite
        System.out.println("This will run before suite...");
    }
    @AfterSuite
    void afterSuite(){
        //executes once after suite
        System.out.println("This will run after suite...");
    }

    @BeforeTest
    void beforeTest(){
        //executes once before test
        System.out.println("This will run before test...");
    }
    @AfterTest
    void afterTest(){
        //executes once after test
        System.out.println("This will run after test...");
    }

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
    void test1(){
        System.out.println("This is test1...");
    }

    @Test(priority = 1)
    void test2(){
        System.out.println("This is test2...");
    }

    @Test(priority = 2, enabled = false) //disable this test
    void test3(){
        System.out.println("This is test3...");
    }


}
