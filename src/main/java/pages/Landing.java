package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Landing {
    WebDriver driver;
    By searchInput = By.name("q");

    public Landing(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate(){
        driver.navigate().to("https://duckduckgo.com/");
    }

    public void search(String query){
        driver.findElement(searchInput).sendKeys(query, Keys.ENTER);
    }
}
