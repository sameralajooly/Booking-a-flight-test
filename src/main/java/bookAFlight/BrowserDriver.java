package bookAFlight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BrowserDriver {
    public WebDriver driver;

    public void initializeDriver() {
        String driverPath = "C:\\tools\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
    }

    public void defaultSettings() {
        driver.get("http://newtours.demoaut.com/mercurywelcome.php");
        driver.manage().window().maximize();
    }

    public String getCurrentURL(){
        String fullURL = driver.getCurrentUrl();
        String currentURL = fullURL.split("\\?")[0];
        return currentURL;
    }
}
