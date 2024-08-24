package testPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task4Tests {
    /**
     * _ Task #4 - Difficulty: Moderate ________________
     * Open Mozilla Firefox
     * Navigate to [https://duckduckgo.com/]
     * Search for [TestNG]
     * Assert that the text of the fourth result is [TestNG Tutorial]
     * Close Mozilla Firefox
     */
    @Test
    public void testTask4() {
        WebDriver driver;
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://duckduckgo.com/");

        By searchInput = By.name("q");
        driver.findElement(searchInput).sendKeys("TestNG", Keys.ENTER);

        Wait<WebDriver> wait;

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NotFoundException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(AssertionError.class);

        wait.until(d -> {
            By fourthResultText = By.xpath("(//article)[4]//h2");
            //  (//article)[4]//h2
            //  (//article//h2)[4]
            String actual = driver.findElement(fourthResultText).getText();
            Assert.assertEquals(actual,"TestNG Tutorial");
            return true;
        });

        driver.quit();
    }
}
