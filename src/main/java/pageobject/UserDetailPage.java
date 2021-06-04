package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserDetailPage {

    WebDriver driver;
    @FindBy(xpath = "//input[@id='inputName']")
    WebElement name;

    @FindBy(id = "address")
    WebElement address;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "zipCode")
    WebElement zipCode;

    @FindBy(id = "cardType")
    WebElement cardType;

    @FindBy(id = "creditCardNumber")
    WebElement creditCardNumber;

    @FindBy(id = "creditCardMonth")
    WebElement creditCardMonth;

    @FindBy(id = "creditCardYear")
    WebElement creditCardYear;

    @FindBy(id = "nameOnCard")
    WebElement nameOnCard;

    public UserDetailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public UserDetailPage fillName(String firstNmae) {
        name.sendKeys(firstNmae);
        return new UserDetailPage(driver);
    }

    public UserDetailPage fillAddress(String userAdress, String userCity
            , String userState, String userZipCode) {
        address.sendKeys(userAdress);
        city.sendKeys(userCity);
        state.sendKeys(userState);
        zipCode.sendKeys(userZipCode);
        return new UserDetailPage(driver);
    }

    public void fillCreditCard(String usrCardType, String usrCardNum, String month, String year
            , String usrNameOnCard) {
        Select cardTypeSelector = new Select(cardType) ;
        //cardTypeSelector.selectByVisibleText(usrCardType);
        creditCardNumber.sendKeys(usrCardNum);
        creditCardMonth.sendKeys(month);
        creditCardYear.sendKeys(year);
        nameOnCard.sendKeys(usrNameOnCard);

    }

}
