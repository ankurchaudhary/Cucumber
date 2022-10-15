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

    By addButton = By.xpath("//button[@type='ad']");

    By firstName = By.xpath("//input[@name='FirstName']");

    By lastName = By.xpath("//input[@name='LastName']");

    By userName = By.xpath("//input[@name='UserName']");

    By password = By.xpath("//input[@name='Password']");

    By customer_1 = By.xpath("//label/input[@value='15']");
    By customer_2 = By.xpath("//label/input[@value='16']");

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

    public void addFirstName(String firstNameKey){
        driver.findElement(firstName).sendKeys(firstNameKey);
    }

    public void addLastName(String lastNameKey){
        driver.findElement(lastName).sendKeys(lastNameKey);
    }

    public void addUsername(String userNameKey){
        driver.findElement(userName).sendKeys(userNameKey);
    }

    public void addPassword(String passwordKey){
        driver.findElement(password).sendKeys(passwordKey);
    }

    public void selectCustomer(String customerOption){
        if(customerOption.equals("Company AAA")) {
            driver.findElement(customer_1).click();
        }if(customerOption.equals("Company BBB")){
            driver.findElement(customer_2).click();
        }
    }

    public void selectRole(String roleKey){

        Select selectRole = new Select
                (driver.findElement(role));

        if(roleKey.equals("Sales Team")){
            selectRole.selectByIndex(1);
        }
        if(roleKey.equals("Customer")){
            selectRole.selectByIndex(2);
        }
        if(roleKey.equals("Admin")){
            selectRole.selectByIndex(3);
        }
    }

    public void addEmail(String emailKey){
        driver.findElement(email).sendKeys(emailKey);
    }

    public void addPhone(String phoneKey){
        driver.findElement(phone).sendKeys(phoneKey);
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
