package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

class FirefoxDriverManager extends DriverManager
{
    private static final Logger logger = LoggerFactory.getLogger(FirefoxDriverManager.class);

    @Override
    protected WebDriver createDriver() {
        logger.info("Initializing Chrome Driver");
        WebDriverManager.getInstance(CHROME).setup();

        return new FirefoxDriver();
    }


}