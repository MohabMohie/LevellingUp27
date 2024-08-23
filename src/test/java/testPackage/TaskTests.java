package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskTests {

    /**
     * ________________ Task #1 - Difficulty: Basic ________________
     * Open Google Chrome
     * Navigate to [https://www.google.com/ncr]
     * Assert that the page title is [Google]
     * Close Google Chrome
     */
    @Test
    public void task1() {
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().maximize();

//        driver.manage().window().setPosition(new Point(0,0));
//        driver.manage().window().setSize(new Dimension(1920,1080)); //1080p, 720p

        driver.navigate().to("https://www.google.com/ncr");
        var title = driver.getTitle();
        System.out.println(title);

        Assert.assertEquals(title, "Google");
        driver.quit();
    }

    @Test
    public void task2() {
        System.out.println("Google");
    }
}
