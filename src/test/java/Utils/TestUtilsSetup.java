package Utils;

import org.openqa.selenium.WebDriver;

public class TestUtilsSetup {

    WebDriver driver;

    public TestUtilsSetup(WebDriver driver){
        this.driver = driver;
    }

    public void maximizeWindow(){
        driver.manage().window().maximize();
    }
}
