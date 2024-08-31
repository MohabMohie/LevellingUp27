package abstractPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Page {
    public Login(WebDriver driver) {
        super(driver);
    }
    //locators
    //methods
    public void login (String username, String password){
        bot.type(By.id("username"), username);
        bot.type(By.id("password"), password);

    }
}
