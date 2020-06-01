package bookAFlight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Booking extends BookAFlight {


    public String bookAFlight() {
        final String expectedText = "Your itinerary has been booked!";
        final String expectedTax = "$45 USD";
        final String expectedTotal = "$601 USD";

        defaultInitialization();
        login();
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

        String result = Constants.VALID;

        if (errors.size() > 0) {
            result = Constants.INVALID;
            for (String error : errors) {
                System.out.println(error);
            }
        }

        return result;
    }

    public String flightFinder() {
        final String expectedURL = "http://newtours.demoaut.com/mercuryreservation.php";
        ArrayList<String> errors = new ArrayList<>();

        defaultInitialization();
        login();
        {
            Select dropdown = new Select(driver.findElement(By.name("fromPort")));
            if (dropdown.getOptions().size() <= 0) {
                errors.add("From port list should not be empty");
            }
        }
        {
            Select dropdown = new Select(driver.findElement(By.name("toPort")));
            if (dropdown.getOptions().size() <= 0) {
                errors.add("To port list should not be empty");
            }
        }
        {
            Select dropdown = new Select(driver.findElement(By.name("fromMonth")));
            if (dropdown.getOptions().size() <= 0) {
                errors.add("From month list should not be empty");
            }
        }
        {
            Select dropdown = new Select(driver.findElement(By.name("toMonth")));
            if (dropdown.getOptions().size() <= 0) {
                errors.add("To month list should not be empty");
            }
        }
        {
            Select dropdown = new Select(driver.findElement(By.name("airline")));
            if (dropdown.getOptions().size() <= 0) {
                errors.add("Airline list should not be empty");
            }
        }
        {
            String currentURL = getCurrentURL();
            if (!currentURL.equals(expectedURL)) {
                errors.add("Wrong url: " + currentURL);
            }
        }
        driver.quit();

        String result = Constants.VALID;

        if (errors.size() > 0) {
            result = Constants.INVALID;
            for (String error : errors) {
                System.out.println(error);
            }
        }

        return result;
    }

    public String verifyFlightData() {
        final String expectedURL = "http://newtours.demoaut.com/mercuryreservation.php";
        final String expectedFromFlight = "Pangea Airlines 362";
        final String expectedToFlight = "Blue Skies Airlines 630";
        final String expectedFromClass = "First";
        final String expectedToClass = "First";
        final String expectedFromPrice = "274";
        final String expectedToPrice = "270";
        final String expectedFromDate = "5/31/2020";
        final String expectedToDate = "7/31/2020";
        final String expectedTaxes = "$44";
        final String expectedTotal = "$588";


        ArrayList<String> errors = new ArrayList<>();

        defaultInitialization();
        login();

        driver.findElement(By.name("fromPort")).click();
        {
            Select dropdown = new Select(driver.findElement(By.name("fromPort")));
            dropdown.selectByVisibleText("London");
        }
        driver.findElement(By.name("toPort")).click();
        {
            Select dropdown = new Select(driver.findElement(By.name("toPort")));
            dropdown.selectByVisibleText("New York");
        }
        driver.findElement(By.name("fromMonth")).click();
        {
            Select dropdown = new Select(driver.findElement(By.name("fromMonth")));
            dropdown.selectByVisibleText("May");
        }
        driver.findElement(By.name("toMonth")).click();
        {
            Select dropdown = new Select(driver.findElement(By.name("toMonth")));
            dropdown.selectByVisibleText("July");
        }
        driver.findElement(By.name("fromDay")).click();
        {
            Select dropdown = new Select(driver.findElement(By.name("fromDay")));
            dropdown.selectByVisibleText("31");
        }
        driver.findElement(By.name("toDay")).click();
        {
            Select dropdown = new Select(driver.findElement(By.name("toDay")));
            dropdown.selectByVisibleText("31");
        }
        driver.findElement(By.cssSelector("tr:nth-child(7) select:nth-child(1) > option:nth-child(7)")).click();
        driver.findElement(By.cssSelector("tr:nth-child(6) option:nth-child(4)")).click();
        driver.findElement(By.cssSelector("input:nth-child(4)")).click();
        driver.findElement(By.name("findFlights")).click();
        driver.findElement(By.cssSelector("table:nth-child(9) tr:nth-child(7) input")).click();
        driver.findElement(By.name("reserveFlights")).click();


        String fromFlight = driver.findElement(By.cssSelector(".data_left:nth-child(1) > font > b")).getText();
        String toFlight = driver.findElement(By.cssSelector("font > font > font > b")).getText();
        String fromClass = driver.findElement(By.cssSelector("tr:nth-child(3) > .data_center_mono > font")).getText();
        String toClass = driver.findElement(By.cssSelector("tr:nth-child(6) > .data_center_mono > font")).getText();
        String fromPrice = driver.findElement(By.cssSelector("tr:nth-child(3) > .data_center > font")).getText();
        String toPrice = driver.findElement(By.cssSelector("tr:nth-child(6) > .data_center > font")).getText();
        String fromDate = driver.findElement(By.cssSelector(".frame_header_info:nth-child(2) > b > font")).getText();
        String toDate = driver.findElement(By.cssSelector(".data_center_mono > b > font")).getText();
        String taxes = driver.findElement(By.cssSelector("tr:nth-child(8) > .data_left:nth-child(2) > font")).getText();
        String total = driver.findElement(By.cssSelector(".data_left:nth-child(2) b")).getText();

        driver.quit();

        String result = Constants.VALID;


        if (!fromFlight.equals(expectedFromFlight)) {
            errors.add("Wrong from flight: " + fromFlight);
        }
        if (!toFlight.equals(expectedToFlight)) {
            errors.add("Wrong to flight: " + toFlight);
        }
        if (!fromClass.equals(expectedFromClass)) {
            errors.add("Wrong from class: " + fromClass);
        }
        if (!toClass.equals(expectedToClass)) {
            errors.add("Wrong to class: " + toClass);
        }
        if (!fromPrice.equals(expectedFromPrice)) {
            errors.add("Wrong for price: " + fromPrice);
        }
        if (!toPrice.equals(expectedToPrice)) {
            errors.add("Wrong to price: " + toPrice);
        }
        if (!fromDate.equals(expectedFromDate)) {
            errors.add("Wrong for date: " + fromDate);
        }
        if (!toDate.equals(expectedToDate)) {
            errors.add("Wrong to date: " + toDate);
        }
        if (!taxes.equals(expectedTaxes)) {
            errors.add("Wrong tax: " + taxes);
        }
        if (!total.equals(expectedTotal)) {
            errors.add("Wrong total: " + total);
        }

        if (errors.size() > 0) {
            result = Constants.INVALID;
            for (String error : errors) {
                System.out.println(error);
            }
        }

        return result;
    }
}
