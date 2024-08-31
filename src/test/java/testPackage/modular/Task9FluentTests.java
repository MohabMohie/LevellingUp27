package testPackage.modular;

import fluent.pages.Landing;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task9FluentTests {
    WebDriver driver;

    @Test
    public void checkFirstSearchResultLink(){
        new Landing(driver).navigate()
                .search("Selenium WebDriver")
                .checkResultLink(1, "https://www.selenium.dev/documentation/webdriver/");
    }

    @Test
    public void checkFourthSearchResultText(){
        new Landing(driver).navigate()
                .search("TestNG")
                .checkResultText(4, "TestNG Tutorial");
    }

    @Test
    public void checkFirstSearchResultText(){
        new Landing(driver).navigate()
                .search("SHAFT_Engine")
                .checkResultText(1, "SHAFT: Unified Test Automation Engine - GitHub");
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = new FirefoxDriver();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1280,720));
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
