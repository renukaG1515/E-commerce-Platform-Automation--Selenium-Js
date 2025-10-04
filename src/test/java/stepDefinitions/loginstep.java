package stepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;

import io.cucumber.java.en.*;
import utils.DriverFactory;
public class loginstep  {

	WebDriver driver;
	
	DriverFactory driverfactory=new DriverFactory();

    @Given("I launch the Swag Labs login page")
    public void i_launch_the_swag_labs_login_page() {
    	
    	
    	driver=driverfactory.launchome();
        
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("I click the login button")
    public void i_click_the_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should be redirected to the inventory page")
    public void i_should_be_redirected_to_the_inventory_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/v1/inventory.html");
        driver.quit();
    }

	
	
	
	
	
	
}
