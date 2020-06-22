import org.testng.annotations.Test;

public class TestGrouping {


    @Test(groups = {"sanity"})
    void testA(){
        System.out.println("Running testA...");
    }

    @Test(groups = {"sanity"})
    void testB(){
        System.out.println("Running testA...");
    }

    @Test(groups = {"regression"})
    void testC(){
        System.out.println("Running testA...");
    }

    @Test(groups = {"sanity","regression"})
    void testD(){
        System.out.println("Running testA...");
    }
}
