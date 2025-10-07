package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.DriverFactory;


public class loginpage {
	
	
	 WebDriver driver = DriverFactory.getDriver(); // ✅ Get it statically
	 
	 public loginpage(WebDriver driver) {
	        this.driver = driver;
	    }

	    By usernameField = By.id("user-name");
	    By passwordField = By.id("password");
	    By loginButton = By.id("login-button");

	    public void login(String username, String password) {
	        driver.findElement(usernameField).sendKeys(username);
	        driver.findElement(passwordField).sendKeys(password);
	        driver.findElement(loginButton).click();
	    }	
	

}
