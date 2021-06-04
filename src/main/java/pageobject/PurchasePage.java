package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PurchasePage {
    WebDriver driver ;

    @FindBy (xpath = "//input[@type='submit']" )
    WebElement purchaseFlight ;

    public  PurchasePage(WebDriver driver)
    {
        this.driver = driver ;
        PageFactory.initElements(driver,this);
    }

    public  ConfirmationPage purchase()
    {
        new UserDetailPage(driver).fillName("rahul Kumar")
        .fillAddress("3RD STREET","Delhi","Delhi","110059")
        .fillCreditCard("VISA","123456789","11","2022","Rahul");
        purchaseFlight.click();
        return new ConfirmationPage(driver);
    }


}
