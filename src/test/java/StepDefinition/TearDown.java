package StepDefinition;

import Utils.TestContextSetup;
import io.cucumber.java.After;

import java.io.IOException;

public class TearDown {

    public TestContextSetup testContextSetup;

    public TearDown(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @After
    public void tearDown() throws IOException {
        testContextSetup.driverSetup.getDriver().quit();
    }

}
