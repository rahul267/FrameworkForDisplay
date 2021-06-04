package driver;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class  DriverFactory {
    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);
    private DriverFactory(){}

    public static DriverManager getManager(DriverType type) {

        DriverManager driverManager = null;
        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                 driverManager = new FirefoxDriverManager();
                break;
            default:
                logger.error("Please supply a correct browser like CHROME or FIREFOX");
                break;
        }
        return driverManager;


    }
}
