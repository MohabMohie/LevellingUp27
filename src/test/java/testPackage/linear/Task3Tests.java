package testPackage.linear;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Task3Tests {
    @Test
    public void testMethod(){
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1920,1080)); //1080p, 720p

        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");

        //write something in test input (unique)
//        By.className("");
//        By.id("my-text-id");
//        By.name("my-text");
//        By.linkText("");
//        By.partialLinkText("");
//        By.tagName("");

//        By.cssSelector("");
//        By.xpath("//input[@id='my-text-id']");

        /**
         * XPATH golden rules
         *
         * Absolute XPATH
         * /html/body/main/div/form/div/div[1]/label[1]/input
         * //*[@id="my-text-id"]
         *
         * Relative XPATH
         * //tagName[@attribute='value']
         *
         * //tagName[@attribute1='value1'][@attribute2='value2']
         * //tagName[@attribute1='value1' and @attribute2='value2']
         * //tagName[@attribute1='value1' or @attribute2='value2']
         *
         * //tagName[@attribute]
         * //tagName
         * //*[@attribute='value']
         *
         * //tagName[text()='']
         * //tagName[contains(@attribute,'value')]
         * //tagName[contains(text(),'value')]
         * //tagName[contains(.,'value')]
         *
         * //tagName[@attribute='value']/tagName[@attribute='value']
         * //tagName[@attribute='value']//tagName[@attribute='value']
         *
         * //tagName[index]
         * (//tagName[@attribute])[index]
         *
         * Dynamic XPATH
         *
         */

        driver.findElement( By.xpath("//input[@id='my-text-id']")).sendKeys("");

        By textInput = By.xpath("//input[@id='my-text-id']");
        driver.findElement(textInput).sendKeys("");

        WebElement textInputElement = driver.findElement( By.xpath("//input[@id='my-text-id']"));
        textInputElement.sendKeys("");

//        @FindBy -> Page Factory Pattern


        //press submit
    }
}
