package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class logoutpage {
	
	 WebDriver driver;

	    public logoutpage(WebDriver driver) {
	        this.driver = driver;
	    }

	    By menuBtn = By.className("bm-burger-button"); // Update this
	    By logoutBtn = By.id("logout_sidebar_link"); // Update this

	    public void logout() {
	        driver.findElement(menuBtn).click();
	        driver.findElement(logoutBtn).click();
	    }

	    public void verifyLogout() {
	        if (driver.getCurrentUrl().contains("login")) {
	            System.out.println("User successfully logged out.");
	        } else {
	            System.out.println("Logout verification failed.");
	        }
	    }

}
