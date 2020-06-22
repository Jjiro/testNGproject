
import org.testng.annotations.*;

public class DataProviderSamples {

    /*@DataProvider(name="LoginDataProvider")
    public Object[][] getData() {
            Object[][] data =  { {"James","james@email.com"},{"Dawn","dawn@email.com"},{"Paula","paula@email.com"},{"Katie","katie@email.com"}};
            return data;
    }*/

    @Test(dataProvider = "LoginDataProvider", dataProviderClass = CustomDataProvider.class)
    public void loginTest(String name, String email){
        System.out.println(name + "  " + email);
    }

}
