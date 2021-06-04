package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    WebDriver driver;
    private String url = "https://blazedemo.com/";

    @FindBy(xpath = "//select[@name='fromPort']")
    WebElement departureCitySelector ;

    @FindBy(xpath = "//select[@name='toPort']")
    WebElement arrivalCitySelector  ;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submitButton ;

    public  HomePage(WebDriver driver)
    {
        this.driver = driver ;
        PageFactory.initElements(driver,this);

    }

    public ReservePage searchFlight(String fromCity, String toCity)
    {
        Select fromCitySelector = new Select(departureCitySelector);
        Select toCitySelector = new Select(arrivalCitySelector);
        fromCitySelector.selectByVisibleText(fromCity);
        toCitySelector.selectByVisibleText(toCity);
        submitButton.click();
        return new ReservePage(driver) ;
    }

    public HomePage goTo()
    {
        driver.get(url);
        return new HomePage(driver);
    }
}
