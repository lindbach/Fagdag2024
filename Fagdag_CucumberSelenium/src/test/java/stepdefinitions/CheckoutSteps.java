package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import static stepdefinitions.Hook.driver;

public class CheckoutSteps {
    private String item;

    @Given("I have added {string} to the cart")
    public void iHaveAddedToTheCart(String item) {
        this.item = item;
        System.out.println("Adding "+item+ " to the cart.");
        driver.findElement(By.xpath("//*[contains(text(), '"+item+"')]/parent::*/parent::*/parent::*//*[contains(text(), 'Add to cart')]")).click();
    }

    @And("I am on the checkout page")
    public void iAmOnTheCheckoutPage() {
        System.out.println("Clicking shopping cart icon.");
        driver.findElement(By.xpath("//*[contains(@class,'shopping_cart_link')]")).click();
        System.out.println("Verifying 'Your Cart' text is present.");
        driver.findElement(By.xpath("//*[contains(text(), 'Your Cart')]"));
        System.out.println("Clicking 'Checkout' button.");
        driver.findElement(By.xpath("//*[contains(@name,'checkout')]")).click();
    }



    @And("I click the continue button")
    public void iClickTheContinueButton() {
        System.out.println("Clicking 'Continue' button.");
        driver.findElement(By.xpath("//*[contains(@id,'continue')]")).click();
    }

    @And("I click the finish button")
    public void iClickTheFinishButton() throws InterruptedException {
        System.out.println("Verifying presence of "+item+".");
        Thread.sleep(3000);
        String paymentInformation = driver.findElement(By.xpath("//*[contains(@data-test,'payment-info-value')]")).getText();
        if(driver.findElement(By.xpath("//*[contains(text(), '"+item+"')]")).isDisplayed()){
            System.out.println("Found "+item+" on confirmation page with payment: "+paymentInformation);
        }
        System.out.println("Clicking 'Finish' button.");
        driver.findElement(By.xpath("//*[contains(@id,'finish')]")).click();
    }

    @Then("I should see a confirmation message")
    public void iShouldSeeAConfirmationMessage() {
        if(driver.findElement(By.xpath("//*[contains(@id,'checkout_complete_container')]")).isDisplayed()){
            System.out.println("Order confirmation is present.");
        }

    }

    @When("I leave the shipping details blank")
    public void iLeaveTheShippingDetailsBlank() {
        //Filler statement
    }

    @When("I enter valid shipping details")
    public void iEnterValidShippingDetails(DataTable dataTable) {
        // Convert the table into a map for easy key-value access
        Map<String, String> details = dataTable.asMap(String.class, String.class);

        driver.findElement(By.xpath("//*[contains(@id,'first-name')]")).sendKeys(details.get("FirstName"));
        driver.findElement(By.xpath("//*[contains(@id,'last-name')]")).sendKeys(details.get("LastName"));
        driver.findElement(By.xpath("//*[contains(@id,'postal-code')]")).sendKeys(details.get("ZipCode"));
    }
}
