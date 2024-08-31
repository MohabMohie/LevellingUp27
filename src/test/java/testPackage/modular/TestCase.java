package testPackage.modular;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestCase {
    WebDriver driver;

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
