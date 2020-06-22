import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCase2 {

    @Test(priority = 0)
    void setUp(){
        System.out.println("Opening browser...");
    }

    @Test(priority = 1)
    void searchCustomer(){
        System.out.println("Searching for Customer");
        Assert.assertEquals(1, 2);
    }

    @Test(priority = 2)
    void addCustomer(){
        System.out.println("Adding for Customer");
    }

    @Test(priority = 3)
    void tearDown(){
        System.out.println("Closing browser...");
    }

}
