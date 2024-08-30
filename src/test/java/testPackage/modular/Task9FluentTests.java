package testPackage.modular;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.pages.Landing;
import pom.pages.Results;

import java.time.Duration;

public class Task9FluentTests {
    WebDriver driver;
    Wait<WebDriver> wait;

    Landing landingPage;
    Results resultsPage;

    @Test
    public void checkFirstSearchResultLink(){
        new fluent.pages.Landing(driver).navigate()
                .search("Selenium WebDriver")
                .checkResultLink(1, "https://www.selenium.dev/documentation/webdriver/");
    }

    @Test
    public void checkFourthSearchResultText(){
        landingPage.search("TestNG");

        wait.until(d -> {
            String actual = resultsPage.getResultText(4);
            Assert.assertEquals(actual,"TestNG Tutorial");
            return true;
        });
    }

    @Test
    public void checkFirstSearchResultText(){
        landingPage.search("Selenium WebDriver");

        wait.until(d -> {
            String actual = resultsPage.getResultText(1);
            Assert.assertEquals(actual,"WebDriver | Selenium");
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
        resultsPage = new Results(driver);

        landingPage.navigate();
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
