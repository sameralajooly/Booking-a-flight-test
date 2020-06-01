package bookAFlight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BookAFlight extends BrowserDriver {

    public void defaultInitialization() {
        initializeDriver();
        defaultSettings();
    }

    public void login(){
        driver.findElement(By.name("userName")).click();
        driver.findElement(By.name("userName")).sendKeys("ExaltTest");
        driver.findElement(By.name("password")).sendKeys("ExaltTest");
        driver.findElement(By.name("login")).click();
    }

}
