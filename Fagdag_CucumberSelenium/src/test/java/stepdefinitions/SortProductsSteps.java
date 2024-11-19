package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SortProductsSteps {
    @Given("I am logged in to Swag Labs")
    public void iAmLoggedInToSwagLabs() {
        System.out.println("Check");
    }

    @And("I am on the products page")
    public void iAmOnTheProductsPage() {
    }

    @When("I sort products by {string}")
    public void iSortProductsBy(String arg0) {
    }

    @Then("the first product should be the cheapest")
    public void theFirstProductShouldBeTheCheapest() {
    }

    @Then("the first product should be alphabetically first")
    public void theFirstProductShouldBeAlphabeticallyFirst() {
    }
}
