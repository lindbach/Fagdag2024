package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RemoveFromCartSteps {
    @And("I am on the cart page")
    public void iAmOnTheCartPage() {
        System.out.println("Verify you're on the cart page");
    }

    @When("I remove the {string}")
    public void iRemoveThe(String arg0) {
        System.out.println("Remove cart item.");
    }

    @Then("I should see the cart is empty")
    public void iShouldSeeTheCartIsEmpty() {
        System.out.println("Verify cart is empty.");
    }
}
