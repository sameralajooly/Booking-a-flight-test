package bookAFlight;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class LoginTest {
    public static final String VALID = "Valid";
    public static final String INVALID = "Invalid";
    private static WebDriver driver;


    public static String bookAFlight() {
        final String expectedText = "Your itinerary has been booked!";
        final String expectedTax = "$45 USD";
        final String expectedTotal = "$601 USD";

        initializeDriver();
        defaultSettings();
        driver.findElement(By.name("userName")).click();
        driver.findElement(By.name("userName")).sendKeys("ExaltTest");
        driver.findElement(By.name("password")).sendKeys("ExaltTest");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.name("toPort")).click();
        {
            Select dropdown = new Select(driver.findElement(By.name("toPort")));
            dropdown.selectByVisibleText("London");
        }
        driver.findElement(By.name("toPort")).click();
        driver.findElement(By.name("toDay")).click();
        {
            Select dropdown = new Select(driver.findElement(By.name("toDay")));
            dropdown.selectByVisibleText("2");
        }
        driver.findElement(By.name("toDay")).click();
        driver.findElement(By.name("toMonth")).click();
        {
            Select dropdown = new Select(driver.findElement(By.name("toMonth")));
            dropdown.selectByVisibleText("June");
        }
        driver.findElement(By.name("toMonth")).click();
        driver.findElement(By.name("findFlights")).click();
        driver.findElement(By.cssSelector("table:nth-child(9) tr:nth-child(7) input")).click();
        driver.findElement(By.cssSelector("table:nth-child(10) tr:nth-child(7) input")).click();
        driver.findElement(By.name("reserveFlights")).click();
        driver.findElement(By.name("buyFlights")).click();

        String text = driver.findElement(By.cssSelector("p > font font:nth-child(2)")).getText();
        String tax = driver.findElement(By.cssSelector("font > font > font font")).getText();
        String total = driver.findElement(By.cssSelector("font > b b > font")).getText();

        driver.quit();

        ArrayList<String> errors = new ArrayList<>();

        if (!text.equals(expectedText)) {
            errors.add("Wrong text: " + text);
        }
        if (!tax.equals(expectedTax)) {
            errors.add("Wrong tax: " + tax);
        }
        if (!total.equals(expectedTotal)) {
            errors.add("Wrong total: " + total);
        }

        String result = VALID;

        if (errors.size() > 0) {
            result = INVALID;
            for (String error : errors) {
                System.out.println(error);
            }
        }

        return result;
    }


    public static String invalidLogin() {
        initializeDriver();
        defaultSettings();

        final String registrationLinkText = "registration form";


        driver.findElement(By.name("userName")).click();
        driver.findElement(By.name("userName")).sendKeys("invalid");
        driver.findElement(By.name("password")).sendKeys("invalid");
        driver.findElement(By.name("login")).click();

        List<WebElement> elements = driver.findElements(By.linkText(registrationLinkText));

        driver.quit();

        String result = VALID;
        if (elements.size() <= 0) {
            result = INVALID;
            System.out.println("Registration link doesn't exist");
        }

        return result;
    }


    private static void initializeDriver() {
        String driverPath = "C:\\tools\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
    }

    private static void defaultSettings() {
        driver.get("http://newtours.demoaut.com/mercurywelcome.php");
        driver.manage().window().maximize();
    }
}
