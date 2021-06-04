package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

    WebDriver driver ;
    @FindBy(xpath = "//h1")
    WebElement thankYouText ;

    public ConfirmationPage(WebDriver driver){
        this.driver = driver ;
        PageFactory.initElements(driver,this);
    }

    public String getThankyou()
    {
        return thankYouText.getText() ;
    }
}
