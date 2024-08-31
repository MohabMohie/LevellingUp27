package testPackage.modular;

import fluent.pages.Landing;
import org.testng.annotations.Test;

public class Task10AbstractTests extends TestCase{

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
}
