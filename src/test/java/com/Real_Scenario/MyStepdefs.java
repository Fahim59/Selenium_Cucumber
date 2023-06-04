package com.Real_Scenario;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("I'm dummy")
    public void iMDummy() {
        System.out.println("I'm dummy");
    }

    @When("I do dummy things")
    public void iDoDummyThings() {
        System.out.println("I do dummy things");
    }

    @Then("Dummy things happen")
    public void dummyThingsHappen() {
        System.out.println("Dummy things happen");
    }

    @Given("my account balance is ${int}")
    public void my_account_balance_is_$(Integer balance) {
        System.out.println(balance);
    }
    @When("I withdraw ${int}")
    public void i_withdraw_$(Integer withdraw) {
        System.out.println(withdraw);
    }
    @Then("the account balance should be ${int}")
    public void the_account_balance_should_be_$(Integer closing) {
        System.out.println(closing);
    }

    @Given("I'm Fahim")
    public void iMFahim() {
        System.out.println("I'm Fahim");
    }

    @And("I'm logged in")
    public void iMLoggedIn() {
        System.out.println("I'm logged in");
    }

    @When("I can do x thing")
    public void iCanDoXThing() {
        System.out.println("I can do x thing");
    }

    @Then("x thing should happen")
    public void xThingShouldHappen() {
        System.out.println("x thing should happen");
    }

    @Given("I'm exploring something")
    public void iMExploringSomething() {
        System.out.println("I'm exploring something");
    }

    @When("I can do y thing")
    public void iCanDoYThing() {
        System.out.println("I can do y thing");
    }

    @Then("y thing should happen")
    public void yThingShouldHappen() {
        System.out.println("y thing should happen");
    }

    @Given("I'm on the Home page and I navigate to the Store page by pressing {string} menu option")
    public void iMOnTheHomePageAndINavigateToTheStorePageByPressingMenuOption(String arg0) {
    }

    @When("I click {string} button next to the product {string}")
    public void iClickButtonNextToTheProduct(String arg0, String arg1) {
    }

    @Then("The {string} button changes and a tick mark is shown on it")
    public void theButtonChangesAndATickMarkIsShownOnIt(String arg0) {
    }

    @Then("{string} link is shown")
    public void linkIsShown(String arg0) {
    }

    @When("I click on the {string} link")
    public void iClickOnTheLink(String arg0) {
    }

    @Then("I'm navigated to the Cart page")
    public void iMNavigatedToTheCartPage() {
    }

    @When("I fetch the product name and quantity")
    public void iFetchTheProductNameAndQuantity() {
    }

    @Then("The product name is {string}")
    public void theProductNameIs(String arg0) {
    }

    @And("The product quantity is {int}")
    public void theProductQuantityIs(int arg0) {
    }
}
