package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebTable {
    WebDriver driver ;
    @FindBy(xpath = "//table")
    WebElement table ;

    @FindBy(xpath = "//table/tr")
    List<WebElement> rows ;

    @FindBy(xpath = "//table/thead/tr/th")
    WebElement tableHeadRow ;



}
