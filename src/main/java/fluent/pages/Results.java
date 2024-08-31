package fluent.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;

public class Results {
    //webdriver
    private final WebDriver driver;
    Wait<WebDriver> wait;
    //locators
    private By anyResultLink;
    private By anyResultText;
    //constructor
    public Results(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NotFoundException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(AssertionError.class);
    }
    //public methods
    public void checkResultLink(int index, String expectedLink){
        anyResultLink = By.xpath("(//article)["+index+"]//h2/a");
        wait.until(d -> {
            String actualLink = driver.findElement(anyResultLink).getAttribute("href");
            Assert.assertEquals(actualLink, expectedLink);
            return true;
        });
    }
    public void checkResultText(int index, String expectedText) {
        anyResultText = By.xpath("(//article)["+index+"]//h2");
        wait.until(d -> {
            String actualText = driver.findElement(anyResultText).getText();
            Assert.assertEquals(actualText,expectedText);
            return true;
        });
    }
    //private methods
}
