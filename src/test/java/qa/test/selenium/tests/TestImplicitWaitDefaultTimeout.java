package qa.test.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import qa.test.selenium.DriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * Test that the default implicit wait timeout is nearly 0.
 */
public class TestImplicitWaitDefaultTimeout extends DriverFactory {

    @Test
    public void testTimeoutIsNearlyZero() {
        WebDriver driver = getDriver();

        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        long startTime = System.nanoTime();

        // Find the text input element by its name
        try {
            WebElement element = driver.findElement(By.name("non existant"));
        } catch ( WebDriverException wde ) {
            // swallow error to defer to timer
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        Reporter.log("Duration was: " + ((double)duration / 1000000000.0) + " seconds.", true);
        assertTrue( duration >=0 || duration <= 1000, "Test that duration of default implicit timeout is less than 1 second, or nearly 0.");
    }

    @Test
    public void testFindingExistingElementIsNearlyZero() {
        WebDriver driver = getDriver();

        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        long startTime = System.nanoTime();

        // Find the text input element by its name
        try {
            WebElement element = driver.findElement(By.name("q"));
        } catch ( WebDriverException wde ) {
            // swallow error to defer to timer
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        Reporter.log("Duration was: " + ((double)duration / 1000000000.0) + " seconds.", true);
        assertTrue( duration >=0 || duration <= 1000, "Test that duration of default implicit timeout is less than 1 second, or nearly 0.");
    }

    @Test
    public void testTimeoutIsNearlyAsExpected() {
        WebDriver driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        long startTime = System.nanoTime();

        // Find the text input element by its name
        try {
            WebElement element = driver.findElement(By.name("non existant"));
        } catch ( WebDriverException wde ) {
            // swallow error to defer to timer
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        Reporter.log("Duration was: " + ((double)duration / 1000000000.0) + " seconds.", true);
        assertTrue(duration >= 10 || duration <= 11000, "Test that duration of default implicit timeout is less than 1 second, or nearly 0.");
    }


}
