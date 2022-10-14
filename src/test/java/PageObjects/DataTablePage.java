package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DataTablePage {

    public WebDriver driver;

    public DataTablePage(WebDriver driver){
        this.driver = driver;
    }

    By addButton = By.xpath("//button[@type='add']");

    By firstName = By.xpath("//input[@name='FirstName']");

    By lastName = By.xpath("//input[@name='LastName']");

    By userName = By.xpath("//input[@name='UserName']");

    By password = By.xpath("//input[@name='Password']");

    By customer = By. xpath("//label/input[@value='15']");

    By role = By.xpath("//select[@name='RoleId']");

    By email = By.xpath("//input[@name='Email']");

    By phone = By.xpath("//input[@name='Mobilephone']");

    By saveUser = By.xpath("//div[@class='modal-footer']/button[@ng-click='save(user)']");

    By record = By.xpath("//tbody/tr[1]/td[1]");

    By delete = By.xpath("//tbody/tr[3]/td[11]/button[@class='btn btn-link']");

    By ok  = By. xpath("//button[@ng-click='close(btn.result)'][2]");

    By table = By.xpath("//tbody/tr/td");


    public void addRecord(){
        driver.findElement(addButton).click();
    }

    public void addFirstName(){
        driver.findElement(firstName).sendKeys("Ankur");
    }

    public void addLastName(){
        driver.findElement(lastName).sendKeys("Chaudhary");
    }

    public void addUsername(){
        driver.findElement(userName).sendKeys("Teladoc2266");
    }

    public void addPassword(){
        driver.findElement(password).sendKeys("Password123");
    }

    public void selectCustomer(){
        driver.findElement(customer).click();
    }

    public void selectRole(){
        Select selectRole = new Select(driver.findElement(role));
        selectRole.selectByIndex(1);
    }

    public void addEmail(){
        driver.findElement(email).sendKeys("test@test.com");
    }

    public void addPhone(){
        driver.findElement(phone).sendKeys("9991119999");
    }

    public void saveUser(){
        driver.findElement(saveUser).click();
    }

    public String getRecord(){
        return driver.findElement(record).getText();
    }

    public String getUsername(){
        return driver.findElement(By.xpath("//tbody/tr[3]/td[3]")).getText();
    }

    public void deleteRecord(){
        driver.findElement(delete).click();
    }

    public void confirmDelete(){
        driver.findElement(ok).click();
    }

    public List<WebElement> getAllRecords(){
        return driver.findElements(table);
    }
}
