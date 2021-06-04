import driver.DriverFactory;
import driver.DriverManager;
import driver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseUiTest {
    DriverManager driverManager;
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driverManager = DriverFactory.getManager(DriverType.CHROME);
    }


    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
    }


    @AfterMethod
    public void afterMethod() {
        driverManager.close();
    }
}
