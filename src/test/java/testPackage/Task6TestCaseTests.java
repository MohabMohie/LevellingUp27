package testPackage;

import org.testng.annotations.*;

public class Task6TestCaseTests {
    @Test
    public void testMethod1() {
        System.out.println("testMethod1");
    }

    @Test
    public void testMethod2() {
        System.out.println("testMethod2");
    }

    @Test
    public void testMethod3() {
        System.out.println("testMethod3");
    }

    @BeforeMethod
    public void setUpMethod() {
        System.out.println("setUpMethod");
    }

    @AfterMethod
    public void tearDownMethod() {
        System.out.println("tearDownMethod");
    }
}
