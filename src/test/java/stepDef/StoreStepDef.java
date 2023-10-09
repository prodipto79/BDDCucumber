package stepDef;

import contextfactory.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pagefactory.StorePage;
import uitls.DBUtils;
import uitls.ExcelUtils;

public class StoreStepDef  {
    TestContext testContext;
    private WebDriver driver;
    StorePage storePage=null;
    ExcelUtils excelUtils;
    DBUtils dbUtils;
    public StoreStepDef(TestContext testContext){

        storePage = new StorePage(testContext);
        excelUtils = testContext.excelUtils;
        dbUtils = testContext.dbUtils;

    }

    @Given("I am on the store page")
    public void i_am_on_the_store_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Given details");
        storePage.clickStoreLink();
    }
    @When("I add a {string}")
    public void i_add_a(String string) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When details");
        storePage.clickAddToCart();
    }
    @Then("I see {int} {string} in the cart")
    public void i_see_in_the_cart(Integer quantity, String productName) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Then details");
        String cartValue = storePage.getOneProduct();
        System.out.println("Cart Value " + cartValue + " for " + productName);
        dbUtils.DBConnection();
        excelUtils.ExcelObjectCreation();
    }


}
