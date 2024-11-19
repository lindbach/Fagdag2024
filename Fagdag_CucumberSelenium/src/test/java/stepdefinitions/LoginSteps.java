package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static stepdefinitions.Hook.driver;
import static utils.BrowserUtilities.getBaseUrl;

public class LoginSteps {
    @Given("I am on the Swag Labs login page")
    public void iAmOnTheSwagLabsLoginPage() {
        driver.get(getBaseUrl());
    }

    @When("I enter a valid username and password")
    public void iEnterAValidUsernameAndPassword() {
        driver.findElement(By.xpath("//*[contains(@id,'user-name')]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[contains(@id,'password')]")).sendKeys("secret_sauce");
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        driver.findElement(By.xpath("//*[contains(@id,'login-button')]")).click();
    }

    @Then("I should see the products page")
    public void iShouldSeeTheProductsPage() {
        driver.findElement(By.xpath("//*[contains(@id,'inventory_container')]")).click();
    }

    @When("I enter an invalid username or password")
    public void iEnterAnInvalidUsernameOrPassword() {
        driver.findElement(By.xpath("//*[contains(@id,'user-name')]")).sendKeys("not_user");
        driver.findElement(By.xpath("//*[contains(@id,'password')]")).sendKeys("secret_sauce");
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        driver.findElement(By.xpath("//*[contains(@class,'error-message-container error')]"));
    }
}
