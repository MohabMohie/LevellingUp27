package engine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Bot {
    WebDriver driver;
    public Bot (WebDriver driver) {
        this.driver = driver;
    }
    public void type(By locator, String text){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
}
