package testPackage.linear;

import org.testng.Assert;
import org.testng.annotations.*;

public class Task5TestScenarioTests {
    String orderID;

    @Test(dependsOnMethods = {"createOrder", "acceptOrder"}, description="As a user when the rider accepts my order, I should see the status is finalized.")
    public void finalizeOrder() {
        System.out.println("finalizeOrder: "+ orderID);
    }

    @Test(dependsOnMethods = "createOrder")
    public void acceptOrder() {
        System.out.println("acceptOrder: "+ orderID);
    }

    @Test
    public void createOrder() {
        orderID = "123";
        System.out.println("createOrder");
        Assert.assertEquals("","");
        Assert.assertNotEquals("","");

        Assert.assertTrue(true);
        Assert.assertFalse(false);
    }

    @BeforeClass
    public void setUp() {
        System.out.println("setUp");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("tearDown");
    }
}
