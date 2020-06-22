import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDependency {

    /*
    Dependency - if a test depends on another to run, the previous test must pass for the current test to execute
    Example tests below shows that the Boat should be started the next test could be executed and so on...
    */

    @Test
    void startBoat(){
        System.out.println("Boat started...");
        Assert.fail();
    }

    @Test(dependsOnMethods = {"startBoat"})
    void driveBoat(){
        System.out.println("Boat driving...");
    }

    @Test(dependsOnMethods = {"driveBoat"})
    void stopBoat(){
        System.out.println("Boat stopped...");
    }

    @Test(dependsOnMethods = {"driveBoat", "stopBoat"}, alwaysRun = true)
    void parkBoat(){
        System.out.println("Boat parked...");
    }
}
