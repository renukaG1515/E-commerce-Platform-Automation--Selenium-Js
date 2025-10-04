package stepDefinitions;
import java.util.ArrayList;

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
import utils.ExcelReader;
public class loginstep  {

	WebDriver driver;
	
	DriverFactory driverfactory=new DriverFactory();
	ExcelReader excelread=new ExcelReader();
	
	 @Given("I launch the Swag Labs login page")
    public void i_launch_the_swag_labs_login_page() {
    	
    	
    	driver=driverfactory.launchome();
        
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
    	
    	String filepath = "src/test/resources/testdata/TD.xlsx";
        String sheetname = "Sheet2";
        ArrayList<String>  usernames=excelread.dataread(filepath,sheetname,0);
    	ArrayList<String> passwords=excelread.dataread(filepath,sheetname,1);
    	
    	//String ExpURL="https://www.saucedemo.com/v1/inventory.html";
    	
    	 System.out.println("Logging in with: " + usernames);
    	 
    	
    	for (int i = 0; i < usernames.size(); i++) {
            String username = usernames.get(i);
            String password = passwords.get(i);
            
            //launch chrome-
            driver = driverfactory.launchome();
            
      //login 
            
            driver.findElement(By.id("user-name")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.id("login-button")).click();
            
        //logout-
            try {
                Thread.sleep(1000); // Small wait for page load (replace with WebDriverWait ideally)
                driver.findElement(By.className("bm-burger-button")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("logout_sidebar_link")).click();
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Issue during login/logout for user: " + username);
            }

            // Check result
            System.out.println("Tested login with: " + username + " / " + password);
    	}  // restart browser for next test
        }
    	
    	
    	

        @Then("I should be redirected to the inventory page")
        public void i_should_be_redirected_to_the_inventory_page() {
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");
            driver.quit();
    
    	
    	
        //driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

   

	
	
	
	
	
	
}
