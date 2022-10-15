package StepDefinition;

import Utils.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
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

    @AfterStep
    public void AddScreenShot(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            File sourcePath = ((TakesScreenshot)testContextSetup.driverSetup.getDriver()).
                    getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);

            scenario.attach(fileContent,"image/png","image");
        }
    }
}
