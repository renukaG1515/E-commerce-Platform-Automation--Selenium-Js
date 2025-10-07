package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyProductDetails {
	
	
	WebDriver driver;

    public VerifyProductDetails(WebDriver driver) {
        this.driver = driver;
    }
	
	
	public By productdetail=By.xpath("//div[@class='inventory_details_desc']");
	public By productname=By.xpath("//div[@class='inventory_details_name']");
	public By productprice=By.xpath("//div[@class='inventory_details_price']");
	
	
	// In your Page class (e.g., SwagPage.java)

	// 1. For product names
	public String getProductName(int index) {
	    return driver.findElements(By.cssSelector(".inventory_item_name")).get(index).getText();
	}

	public String getProductDetail(int index) {
	    return driver.findElements(By.cssSelector(".inventory_item_desc")).get(index).getText();
	}

	public String getProductPrice(int index) {
	    return driver.findElements(By.cssSelector(".inventory_item_price")).get(index).getText();
	}


}
