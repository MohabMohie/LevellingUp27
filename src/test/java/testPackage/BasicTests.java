package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BasicTests {

    @Test
    public void basicNavigationTest() {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.quit();
    }

    //@Test
    public void browserActionsTest() {
        WebDriver driver;
        driver = new ChromeDriver();

        driver.get("");
        driver.navigate().to("");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        driver.quit();
        driver.close();

        driver.getCurrentUrl();
        driver.getPageSource();
        String windowTitle = driver.getTitle();
        var windowTitle2 = driver.getTitle();

        //////
        driver.getWindowHandle();
        driver.getWindowHandles();

        driver.switchTo().window("");
        driver.switchTo().newWindow(WindowType.TAB).get("");
        driver.switchTo().activeElement();

        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("");

        driver.switchTo().frame(0);
        driver.switchTo().frame("");
        driver.switchTo().parentFrame();

        driver.switchTo().defaultContent();
        //////

//        driver.findElement();
//        driver.findElements();

        driver.quit();
    }
}
