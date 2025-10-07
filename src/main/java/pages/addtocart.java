package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class addtocart {
	
	
	WebDriver driver;

    public addtocart(WebDriver driver) {
        this.driver = driver;
    }

    // Example: Add a product by name (update locator as needed)
    public void addToCartt() {
    	
    	
    	//By product = By.xpath("//*[contains(text(), '" + productName + "')]");
    	

    	    // Locator for Add to Cart button related to this product (adjust as per your app)
    	    // This assumes "Add to Cart" button is visible on the product page or next to product element
    	    By addToCartBtn = By.xpath("//button[text()='ADD TO CART']"); 
    	    
    	    // Click on Add to Cart button
    	    driver.findElement(addToCartBtn).click();
    }
}
