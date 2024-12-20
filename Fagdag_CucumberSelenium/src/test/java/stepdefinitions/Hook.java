package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.time.Duration;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static utils.BrowserUtilities.getBaseUrl;

public class Hook {
    public static WebDriver driver;


    public Hook() {
    }

    @Before
    public void initializeTest() throws IOException {
        String pathToChromedriverExe = "C:/LEGG/PATH/TIL/CHROMEDRIVER/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToChromedriverExe);
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Setting webdriver properties..");
        System.out.println("Starting test..");

        try {
            Thread.sleep(300L);
        } catch (InterruptedException ie) {
            System.out.println("Something happend while thread was sleeping: " + ie);
        }

    }
    @Before("@login")
    public void loginBeforeFeature() {
        driver.get(getBaseUrl());
        driver.findElement(By.xpath("//*[contains(@id,'user-name')]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[contains(@id,'password')]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[contains(@id,'login-button')]")).click();
    }

    @Before("@loginWithProblemUser")
    public void loginBeforeWithProblemUserFeature() {
        driver.get(getBaseUrl());
        driver.findElement(By.xpath("//*[contains(@id,'problem_user')]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[contains(@id,'password')]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[contains(@id,'login-button')]")).click();
    }

    @After
    public void tearDown() throws InterruptedException {
        System.out.println("Closing the test..");
        Thread.sleep(5000L);
        driver.close();
        driver.quit();
    }
}
