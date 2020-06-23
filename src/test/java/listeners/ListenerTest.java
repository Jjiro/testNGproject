package listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(listeners.CustomListeners.class)
public class ListenerTest {


    @Test
    void test1(){
        System.out.println("Printing test1...");
        Assert.assertEquals("B", "B");
    }

    @Test
    void test2(){
        System.out.println("Printing test1...");
        Assert.assertEquals("B", "A");
    }

    @Test
    void test3(){
        System.out.println("Printing test1...");
        Assert.assertEquals("B", "B");
        throw new SkipException("This is a SkipException");
    }



}
