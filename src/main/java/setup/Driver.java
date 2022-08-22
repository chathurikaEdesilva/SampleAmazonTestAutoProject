/**
 * This class is used to introduce dynamic nature to the driver selection depending on the choice of browser
 * Following methods are there
 * getDriver() - returns the web driver according to the browser
 * getDriverProperty() - returns driver property according to the browser
 */

package setup;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {
    WebDriver webDriver;
    ConfigFileReader configFileReader = new ConfigFileReader();
    String browser = configFileReader.getBrowser();

    public WebDriver getDriver() {
        if (browser.equalsIgnoreCase("chrome")) {
            webDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            webDriver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            webDriver = new InternetExplorerDriver();
        }
        return webDriver;
    }

    public String getDriverProperty() {
        String driverPath = null;
        if (browser.equalsIgnoreCase("chrome")) {
            driverPath = "webdriver.chrome.driver";
        } else if (browser.equalsIgnoreCase("firefox")) {
            driverPath = "webdriver.gecko.driver";
        } else if (browser.equalsIgnoreCase("ie")) {
            driverPath = "webdriver.ie.driver";
        }
        return driverPath;
    }
}
