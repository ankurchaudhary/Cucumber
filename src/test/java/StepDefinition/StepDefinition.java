package StepDefinition;

import PageObjects.DataTablePage;
import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

//Use different locators
// nth child
//implicit wait and explicit wait

public class StepDefinition {

    public TestContextSetup testContextSetup;

    public StepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    String username;


    @Given("User is on the DataTable Page")
    public void user_is_on_the_data_table_page() {
    }

    @When("User enters the details")
    public void user_enters_the_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        //PageObjectManager pageObjectManager = new PageObjectManager(testContextSetup.driver);

        DataTablePage dataTablePage = testContextSetup.pageObjectManager.getDataTablePage();

        dataTablePage.addRecord();
        dataTablePage.addFirstName();
        dataTablePage.addLastName();
        dataTablePage.addUsername();
        dataTablePage.addPassword();
        dataTablePage.selectCustomer();
        dataTablePage.selectRole();
        dataTablePage.addEmail();
        dataTablePage.addPhone();
        dataTablePage.saveUser();

    }

    @Then("The Record is successfully added to the table")
    public void the_record_is_successfully_added_to_the_table() throws InterruptedException {
        DataTablePage dataTablePage = testContextSetup.pageObjectManager.getDataTablePage();

        Assert.assertEquals("Ankur",dataTablePage.getRecord());

    }

    @When("User {string} is present in Table")
    public void user_is_present_on_page(String user) throws InterruptedException {
        DataTablePage dataTablePage = testContextSetup.pageObjectManager.getDataTablePage();

        username = dataTablePage.getUsername();
        Assert.assertEquals(user,username);
    }

    @When("^Delete button is clicked$")
    public void delete_button_is_clicked() throws InterruptedException {
        DataTablePage dataTablePage = testContextSetup.pageObjectManager.getDataTablePage();

        if(username.equals("novak")){
            dataTablePage.deleteRecord();
            dataTablePage.confirmDelete();
            System.out.println("Successfully Deleted");
        }
    }
    @Then("The Record is successfully deleted from the table")
    public void the_record_is_successfully_deleted_from_the_table() {
        DataTablePage dataTablePage = testContextSetup.pageObjectManager.getDataTablePage();

        List<WebElement> elements = dataTablePage.getAllRecords();

        for(int k = 0; k < elements.size(); k++){
            Assert.assertFalse(elements.get(k).getText().equals("novak"));
        }


    }
}
