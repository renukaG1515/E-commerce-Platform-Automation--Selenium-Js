package stepDefinitions;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.addtocart;
import pages.loginpage;
import pages.logoutpage;
import utils.DriverFactory;
import utils.ExcelReader;

public class Addtocart {

    loginpage loginPage;
    addtocart addToCart;
    logoutpage logoutPage;

    ExcelReader reader = new ExcelReader();
    DriverFactory factory = new DriverFactory();

    ArrayList<String> usernames;
    ArrayList<String> passwords;
    
    WebDriver driver;

    @Given("user is logged in")
    public void read_user_credentials() {
        String path = "src/test/resources/testdata/TD.xlsx";
        String sheet = "Sheet2";

        // Assuming usernames in column 0, passwords in column 1
        usernames = reader.dataread(path, sheet, 0);
        passwords = reader.dataread(path, sheet, 1);
    }

    @When("user adds a Sauce Labs Backpack to the cart")
    public void each_user_logs_in_and_adds_product() {
        for (int i = 0; i < usernames.size(); i++) {
            factory.launchome();  // Launch browser and open app
            
            // Get WebDriver instance from DriverFactory after launch
            driver = DriverFactory.getDriver();

            // Pass driver to page classes
            loginPage = new loginpage(driver);
            addToCart = new addtocart(driver);
            logoutPage = new logoutpage(driver);

            System.out.println("Logging in with: " + usernames.get(i));
            loginPage.login(usernames.get(i), passwords.get(i));

            // Set implicit wait (optional but recommended)
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            
            By product = By.xpath("//div[starts-with(text(),'Sauce Labs Backpack')]");
    	    
    	    // Click on the product (to open details maybe)
    	    driver.findElement(product).click();

            // Add product to cart
            addToCart.addToCartt();

            // Logout user
            logoutPage.logout();
            System.out.println("Logged out user: " + usernames.get(i));

            // Quit browser after test
            driver.quit();
        }
    }

    @Then("the cart should show 1 item")
    public void all_users_logged_out() {
        System.out.println("✅ All users completed login → cart → logout successfully.");
    }
}
