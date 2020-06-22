import org.testng.annotations.Test;

/**
 * open browser and application
 * login
 * close
**/

public class TestCase1 {

    @Test(priority = 0)
    void setUp(){
        System.out.println("Opening browser...");
    }

    @Test(priority = 1)
    void login(){
        System.out.println("This is the login zone");
    }

    @Test(priority = 2)
    void tearDown(){
        System.out.println("Closing browser...");
    }

}
