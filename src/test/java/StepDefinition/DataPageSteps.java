package StepDefinition;

import PageObjects.DataTablePage;
import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class DataPageSteps {

    public TestContextSetup testContextSetup;

    public DataPageSteps(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    String username;

    @Given("User is on the DataTable Page")
    public void user_is_on_the_data_table_page() {
    }

    @When("^User inserts the record (.+),(.+),(.+),(.+),(.+),(.+),(.+),(.+)$")
    public void user_enters_the_details(String firstname, String lastname, String username, String password, String customer, String role, String email, String CellPhone) throws InterruptedException {

        DataTablePage dataTablePage = testContextSetup.pageObjectManager.getDataTablePage();

        dataTablePage.addRecord();

        dataTablePage.addFirstName(firstname);
        dataTablePage.addLastName(lastname);
        dataTablePage.addUsername(username);
        dataTablePage.addPassword(password);

        dataTablePage.selectCustomer(customer);
        dataTablePage.selectRole(role);

        dataTablePage.addEmail(email);
        dataTablePage.addPhone(CellPhone);

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
