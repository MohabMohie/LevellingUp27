package testPackage.linear;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskTempTests {
    WebDriver driver;

    @Test
    public void testMethod(){
        driver.navigate().to("https://duckduckgo.com/");
        By logoImg = By.xpath("//section[not(contains(@class,'shrink'))]/a[@title='Learn about DuckDuckGo']");
        boolean isDisplayed = driver.findElement(logoImg).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    @Test
    public void testMethod2(){
        driver.navigate().to("http://the-internet.herokuapp.com/checkboxes");
        clickCheckbox(1);
        Assert.assertTrue(isCheckboxSelected(1) && isCheckboxSelected(2));
    }

    private void clickCheckbox(int index){
        By checkbox = By.xpath("//form[@id='checkboxes']/input[@type='checkbox']["+index+"]");
        driver.findElement(checkbox).click();
    }

    private boolean isCheckboxSelected(int index){
        By checkbox = By.xpath("//form[@id='checkboxes']/input[@type='checkbox']["+index+"]");
        return driver.findElement(checkbox).isSelected();
    }

    @Test
    public void testMethod3(){
        driver.navigate().to("https://jqueryui.com/resources/demos/droppable/default.html");
        By draggableDiv = By.id("draggable");
        By droppableDiv = By.id("droppable");

        Actions action = new Actions(driver);
        action.dragAndDrop(driver.findElement(draggableDiv), driver.findElement(droppableDiv)).build().perform();

        String actualResult = driver.findElement(droppableDiv).getText();
        Assert.assertEquals(actualResult, "Dropped!");
    }

    @Test
    public void testMethod4(){
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
        // Assert that the Country for the Company [Ernst Handel] is [Austria]

        //tr[contains(.,'Ernst Handel')]/td[3]
        //td[text()='Ernst Handel']/following-sibling::td[2]

        By countryNameLabel = By.xpath("//tr[contains(.,'Ernst Handel')]/td[3]");

//        By countryNameLabel = RelativeLocator
//                .with(By.tagName("td"))
//                .below(By.xpath("//th[text()='Country']"))
//                .toRightOf(By.xpath("//td[text()='Ernst Handel']"));


        String actualText = driver.findElement(countryNameLabel).getText();

        Assert.assertEquals(actualText, "Austria");
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
