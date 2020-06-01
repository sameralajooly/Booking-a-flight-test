package bookAFlight;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Login extends BookAFlight {


    public String validLogin() {
        final String expectedURL = "http://newtours.demoaut.com/mercuryreservation.php";

        defaultInitialization();

        login();


        String currentURL = getCurrentURL();
        driver.quit();

        String result = Constants.VALID;
        if (!currentURL.equals(expectedURL)) {
            result = Constants.INVALID;
            System.out.println("Wrong url: " + currentURL);
        }

        return result;
    }

    public String invalidLogin() {
        final String registrationLinkText = "registration form";
        final String expectedURL = "http://newtours.demoaut.com/mercurysignon.php";

        defaultInitialization();

        driver.findElement(By.name("userName")).click();
        driver.findElement(By.name("userName")).sendKeys("invalid");
        driver.findElement(By.name("password")).sendKeys("invalid");
        driver.findElement(By.name("login")).click();

        List<WebElement> elements = driver.findElements(By.linkText(registrationLinkText));


        String currentURL = getCurrentURL();

        driver.quit();

        String result = Constants.VALID;
        if (!currentURL.equals(expectedURL)) {
            result = Constants.INVALID;
            System.out.println("Wrong url: " + currentURL);
        }
        if (elements.size() <= 0) {
            result = Constants.INVALID;
            System.out.println("Registration link doesn't exist");
        }

        return result;
    }


}
