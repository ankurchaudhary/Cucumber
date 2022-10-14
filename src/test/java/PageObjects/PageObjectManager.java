package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public WebDriver driver;
    public DataTablePage dataTablePage;


    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }


    public DataTablePage getDataTablePage(){
        dataTablePage = new DataTablePage(driver);
        return dataTablePage;
    }

}
