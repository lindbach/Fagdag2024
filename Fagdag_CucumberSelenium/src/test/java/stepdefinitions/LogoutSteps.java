package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSteps {
    @When("I click the logout button")
    public void iClickTheLogoutButton() {
        System.out.println("Click logout button"); //Placeholder
    }

    @Then("I should be redirected to the login page")
    public void iShouldBeRedirectedToTheLoginPage() {
        System.out.println("Verify landingpage"); //Placeholder
    }
}
