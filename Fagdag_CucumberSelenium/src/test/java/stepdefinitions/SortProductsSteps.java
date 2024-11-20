package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static stepdefinitions.Hook.driver;

public class SortProductsSteps {
    @Given("I am logged in to Swag Labs")
    public void iAmLoggedInToSwagLabs() {
        System.out.println("Check");
        driver.findElement(By.xpath("//*[contains(@id,'react-burger-menu-btn')]")).click();
        driver.findElement(By.xpath("//*[contains(@id,'logout_sidebar_link')]")).isDisplayed();
        driver.findElement(By.xpath("//*[contains(@id,'react-burger-cross-btn')]")).click();
    }

    @And("I am on the products page")
    public void iAmOnTheProductsPage() {
        driver.findElement(By.xpath("//*[contains(@class,'title')]")).isDisplayed();
    }

    @When("I sort products by {string}")
    public void iSortProductsBy(String sortType) {
        driver.findElement(By.xpath("//*[contains(@class,'product_sort_container')]")).click();
        driver.findElement(By.xpath("//*[contains(@value,'lohi')]")).click();
        List<WebElement> elements = (driver.findElements(By.xpath("//*[contains(@class,'inventory_list')]/*")));
        System.out.println("There are "+elements.size()+" elements on the page");

        int firstPrice =0;
        int secondPrice =0;

        for(int i =1; i<elements.size(); i++){
            String priceString = driver.findElement(By.xpath("//*[contains(@id,'inventory_container')]/div/div["+i+"]//*[contains(@class,'inventory_item_price')]")).getText();
            System.out.println(priceString);
            String numericString = priceString.replace("$", "");
            double priceDouble = Double.parseDouble(numericString);
            // Convert to an integer (truncates decimals)
            firstPrice = (int) priceDouble;
            System.out.println("Firstprice: "+firstPrice+" Secondprice: "+secondPrice);
            if(firstPrice>=secondPrice){
                secondPrice = firstPrice;
            }else {
                Assert.fail("The sorting function does not work.\n"+firstPrice +" is lower than "+secondPrice);
            }
        }
    }

    @Then("the first product should be the cheapest")
    public void theFirstProductShouldBeTheCheapest() {
    }

    @Then("the first product should be alphabetically first")
    public void theFirstProductShouldBeAlphabeticallyFirst() {
    }
}
