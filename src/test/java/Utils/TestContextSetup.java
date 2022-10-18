package Utils;

import PageObjects.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {

    public DriverSetup driverSetup;
    public TestUtilsSetup testUtilsSetup;
    public PageObjectManager pageObjectManager;


    public TestContextSetup() throws IOException {
        driverSetup = new DriverSetup();
        testUtilsSetup = new TestUtilsSetup(driverSetup.getDriver());
        pageObjectManager = new PageObjectManager(driverSetup.getDriver());
    }
}
