package utils;

import java.io.FileInputStream;
import java.time.Duration;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

	public static WebDriver driver;

    public WebDriver launchome() {
        try (FileInputStream fs = new FileInputStream("src\\test\\resources\\testdata\\TD.xlsx");
             XSSFWorkbook workbook = new XSSFWorkbook(fs)) {

            XSSFSheet objsheet = workbook.getSheet("Sheet1");
            XSSFRow objrow = objsheet.getRow(2);

            String Browsername = objrow.getCell(0).getStringCellValue();
            String Applicationlink = objrow.getCell(1).getStringCellValue();

            if (Browsername.equalsIgnoreCase("Chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            } else {
                // add other browsers if needed
            }

            driver.get(Applicationlink);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }
    
    
    public static WebDriver getDriver() {
        return driver;
    }
	
    
    
   
    
    
}
