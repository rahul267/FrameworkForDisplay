package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ReservePage {

    WebDriver driver;

    @FindBy (xpath = "//input[@type='submit']" )
    List<WebElement> chooseFlightList ;

    public  ReservePage(WebDriver driver)
    {
        this.driver = driver ;
        PageFactory.initElements(driver,this);
    }

    public PurchasePage chooseFirstFlight()
    {
        chooseFlightList.get(0).click();
        return new PurchasePage(driver) ;
    }

    public PurchasePage chooseCheapeastFlight()
    {
        chooseFlightList.get(0).click();
        return new PurchasePage(driver) ;
    }

}
