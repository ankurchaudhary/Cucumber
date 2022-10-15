package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class DriverSetup {

    String filePath = "src/test/Resources/data.properties";

    public WebDriver driver;

    public WebDriver getDriver() throws IOException {
        Properties properties = null;
        try {
            properties = new Properties();
            properties.load(new FileInputStream(filePath));
        }catch (Exception exc){
            exc.printStackTrace();
        }

        String browser_properties = properties.getProperty("browser");
        String browser_maven = System.getProperty("browser");

        String browser = browser_maven!=null ? browser_maven : browser_properties;

        //create for Firefox
        if(driver == null){
            if(browser.equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get(properties.getProperty("url"));
            }
            if(browser.equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.get(properties.getProperty("url"));
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        }

        return driver;
    }

}
