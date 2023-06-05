package Real_Scenario.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class realStepDef {
    @Given("I'm on the Store Page")
    public void i_m_on_the_store_page() {
        System.out.println("I am on Store Page");
    }
    @When("I add a {string} to the cart")
    public void i_add_a_to_the_cart(String string) {
        System.out.println("I add Product in the cart");
    }
    @Then("I see {int} {string} in the cart")
    public void i_see_in_the_cart(Integer int1, String string) {
        System.out.println("I see Product Quantity");
    }
}
