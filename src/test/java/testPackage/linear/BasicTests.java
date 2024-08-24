package testPackage.linear;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

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

        driver.manage().window().maximize();
        driver.manage().window().minimize();
        driver.manage().window().fullscreen();
        driver.manage().window().getPosition();
        driver.manage().window().getSize();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1920,1080)); //1080p, 720p

        driver.manage().timeouts().getScriptTimeout();
        driver.manage().timeouts().getImplicitWaitTimeout();
        driver.manage().timeouts().getPageLoadTimeout();

        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        //waiting strategies (synchronization)
//        Thread.sleep(3000);

        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("")).click();

        Wait<WebDriver> wait;
//        explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //old -> expected conditions
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
//        driver.findElement(By.xpath("")).isDisplayed();
//        driver.findElement(By.xpath("")).isEnabled();
//        driver.findElement(By.xpath("")).click();

        //new -> lambda expression
        wait.until(d -> {
            driver.findElement(By.xpath("")).click();
            return true;
        });

//        custom wait (fluent wait)
        wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(NotFoundException.class)
                        .ignoring(ElementNotInteractableException.class)
                        .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            driver.findElement(By.xpath("")).click();
            return true;
        });

        driver.quit();
    }
}
