package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

class ChromeDriverManager extends DriverManager
{
    private static final Logger logger = LoggerFactory.getLogger(ChromeDriverManager.class);

    @Override
    protected WebDriver createDriver() {
        logger.info("Initializing Chrome Driver");
        WebDriverManager.getInstance(CHROME).setup();
        return new ChromeDriver(getChromeOptions());
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-features=EnableEphemeralFlashPermission");
        options.addArguments("--disable-infobars");

        return options;
    }
}
