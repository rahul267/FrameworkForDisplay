import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.HomePage;

public class BasicUiTest extends BaseUiTest {

    @Test()
    public void doBasicReservationE2E()
    {
        HomePage homePage = new HomePage(driver) ;
        homePage.goTo();
        String thankYou =
                 new HomePage(driver)
                         .goTo()
                         .searchFlight("Paris","Rome")
                         .chooseFirstFlight()
                         .purchase()
                         .getThankyou().trim();
        Assert.assertEquals(thankYou, "Thank you for your purchase today!"
                ,"User is not on Thanks you page");
    }

    @Test(expectedExceptions ={org.openqa.selenium.NoSuchElementException.class} )
    public void SrcAndDestSameThrowsExceptionTest()
    {

       new HomePage(driver)
                .goTo()
                .searchFlight("Paris","Paris").chooseFirstFlight();

    }

}
