package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Results {
    //webdriver
    private final WebDriver driver;
    //locators
    private final By firstLink = By.xpath("(//article)[1]//h2/a");
    private By anyResultText;

    //constructor
    public Results(WebDriver driver) {
        this.driver = driver;
    }
    //public methods
    public String getFirstResultLink() {
        return driver.findElement(firstLink).getAttribute("href");
    }

    public String getResultText(int i) {
        anyResultText = By.xpath("(//article)["+i+"]//h2");
        return driver.findElement(anyResultText).getText();
    }
    //private methods
}
