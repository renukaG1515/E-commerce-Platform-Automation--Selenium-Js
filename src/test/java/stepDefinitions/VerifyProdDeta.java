package stepDefinitions;

import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.VerifyProductDetails;
import utils.DriverFactory;
import utils.ExcelReader;



public class VerifyProdDeta {
	
	
		WebDriver driver;
	

	  ExcelReader reader = new ExcelReader();
	    DriverFactory factory = new DriverFactory();
	    VerifyProductDetails page = new VerifyProductDetails(null);

	    ArrayList<String> usernames;
	    ArrayList<String> passwords;
	 
	    

	   

	    @Given("user is logged in to swaglab")
	    public void read_user_credentials() {
	        String path = "src/test/resources/testdata/TD.xlsx";
	        String sheet = "Sheet2";

	        usernames = reader.dataread(path, sheet, 0);
	        passwords = reader.dataread(path, sheet, 1);
	    }

	    @When("user adds a Sauce Labs Backpack to the cart and validates product details")
	    public void each_user_logs_in_and_validates_product_details() {
	        

	        // Read product names and prices from Excel once
	    	String path = "src/test/resources/testdata/TD.xlsx";
	    	String sheet = "Sheet3";

	    	// 0 = Detail, 1 = Name, 2 = Price
	    	ArrayList<String> productDetails = reader.readColumn(path, sheet, 0);
	    	ArrayList<String> productNames = reader.readColumn(path, sheet, 1);
	    	ArrayList<String> productPrices = reader.readColumn(path, sheet, 2);

	        for (int i = 0; i < usernames.size(); i++) {
	            factory.launchome();  // Launch browser and open app
	            driver = DriverFactory.getDriver();

	            // Login
	            pages.loginpage loginPage = new pages.loginpage(driver);
	            loginPage.login(usernames.get(i), passwords.get(i));

	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	            pages.addtocart addToCart = new pages.addtocart(driver);
	            
	            By product = By.xpath("//div[starts-with(text(),'Sauce Labs Backpack')]");
	    	    
	    	    // Click on the product (to open details maybe)
	    	    driver.findElement(product).click();
	    	    System.out.println(">>> Inside verifyProductDetails step");

	    	    for (int i1 = 0; i1 < productNames.size(); i1++) {
	    	        System.out.println(">>> Inside product comparison loop! Product index: " + i1);

	    	        String expectedDetail = productDetails.get(i1);
	    	        String expectedName = productNames.get(i1);
	    	        String expectedPrice = productPrices.get(i1);

	    	        String actualDetail = page.getProductDetail(i1);
	    	        String actualName = page.getProductName(i1);
	    	        String actualPrice = page.getProductPrice(i1);

	    	        if (actualDetail.equals(expectedDetail)) {
	    	            System.out.println("✅ Description matched.");
	    	        } else {
	    	            System.out.println("❌ Description mismatch!");
	    	            assert actualDetail.equals(expectedDetail) : "❌ Description mismatch!";
	    	        }

	    	        if (actualName.equals(expectedName)) {
	    	            System.out.println("✅ Name matched.");
	    	        } else {
	    	            System.out.println("❌ Name mismatch!");
	    	            assert actualName.equals(expectedName) : "❌ Name mismatch!";
	    	        }

	    	        if (actualPrice.equals(expectedPrice)) {
	    	            System.out.println("✅ Price matched.");
	    	        } else {
	    	            System.out.println("❌ Price mismatch!");
	    	            assert actualPrice.equals(expectedPrice) : "❌ Price mismatch!";
	    	        }
	    	    }
	           
	            // Logout
	            pages.logoutpage logoutPage = new pages.logoutpage(driver);
	            logoutPage.logout();

	            DriverFactory.getDriver().quit();  // Close browser for this user
	        }
	    }

	    @Then("the cart should add 1 item")
	    public void all_users_logged_out() {
	        System.out.println("✅ All users completed login → product validation → logout successfully.");
	    }
	}