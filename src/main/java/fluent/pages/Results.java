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
    private By firstLink;
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
    public String getFirstResultLink() {
        return driver.findElement(firstLink).getAttribute("href");
    }

    public String getResultText(int i) {
        anyResultText = By.xpath("(//article)["+i+"]//h2");
        return driver.findElement(anyResultText).getText();
    }

    public void checkResultLink(int index, String expectedLink){
        firstLink = By.xpath("(//article)["+index+"]//h2/a");
        wait.until(d -> {
            String actualLink = driver.findElement(firstLink).getAttribute("href");
            Assert.assertEquals(actualLink, expectedLink);
            return true;
        });
    }
    //private methods
}
