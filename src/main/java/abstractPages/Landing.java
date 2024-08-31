package abstractPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Landing extends Page{
    private final By searchInput = By.name("q");

    public Landing(WebDriver driver) {
        super(driver);
    }


    public Landing navigate(){
        driver.navigate().to("https://duckduckgo.com/");
        return this;
    }

    public Results search(String query){
        driver.findElement(searchInput).sendKeys(query, Keys.ENTER);
        return new Results(driver);
    }
}
