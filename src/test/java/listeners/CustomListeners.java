package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListeners implements ITestListener {


    //Test belongs to ITestListener which executes before starting test set/batch
    public void onStart(ITestContext arg){
        System.out.println("Starting test execution..." + arg.getName());
    }

    public void onFinish(ITestContext arg){
        System.out.println("Finishing test execution..." + arg.getName());
    }

    public void onTestStart(ITestResult arg){
        System.out.println("Starting test execution..." + arg.getName());
    }

    public void onTestSkipped(ITestResult arg){
        System.out.println("Skipping test execution..." + arg.getName());
    }

    public void onTestSuccess(ITestResult arg){
        System.out.println("Passed test execution..." + arg.getName());
    }

    public void onTestFailure(ITestResult arg){
        System.out.println("Failed test execution..." + arg.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg){
        System.out.println("Failed test execution within success percentage..." + arg.getName());
    }


}
