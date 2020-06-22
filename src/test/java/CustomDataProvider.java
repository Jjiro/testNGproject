import org.testng.annotations.DataProvider;

public class CustomDataProvider {

    @DataProvider(name="LoginDataProvider")
    public Object[][] getData() {
        Object[][] data =  { {"James","james@email.com"},{"Dawn","dawn@email.com"},{"Paula","paula@email.com"},{"Katie","katie@email.com"}};
        return data;
    }


}
