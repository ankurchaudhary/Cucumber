package Utils;

import PageObjects.PageObjectManager;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestContextSetup {

    public DriverSetup driverSetup;
    public PageObjectManager pageObjectManager;


    public TestContextSetup() throws IOException {
        driverSetup = new DriverSetup();
        pageObjectManager = new PageObjectManager(driverSetup.getDriver());
    }
}
