package testPackage.modular;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Landing;

import java.time.Duration;

public class Task8Tests {
    WebDriver driver;
    Wait<WebDriver> wait;

    Landing landingPage;

    @Test
    public void checkFirstSearchResult(){
        String searchQuery = "Selenium WebDriver";
        landingPage.search(searchQuery);

        wait.until(d -> {
            By firstLink = By.xpath("(//article)[1]//h2/a");
            String actualLink = driver.findElement(firstLink).getAttribute("href");
            Assert.assertEquals(actualLink, "https://www.selenium.dev/documentation/webdriver/");
            return true;
        });
    }

    @Test
    public void checkFourthSearchResult(){
        By searchInput = By.name("q");
        driver.findElement(searchInput).sendKeys("TestNG", Keys.ENTER);

        wait.until(d -> {
            By fourthResultText = By.xpath("(//article)[4]//h2");
            String actual = driver.findElement(fourthResultText).getText();
            Assert.assertEquals(actual,"TestNG Tutorial");
            return true;
        });
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = new FirefoxDriver();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NotFoundException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(AssertionError.class);

        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1280,720));

        landingPage = new Landing(driver);
        landingPage.navigate();
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
