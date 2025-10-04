package utils;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public WebDriver driver;

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
    
    
    public ArrayList<String> dataread(String Filepath,String Sheetname,int cellno)
	{
		
		
		ArrayList<String> obja=new ArrayList<String>();
		
		try
		{
			
			FileInputStream fs=new FileInputStream(Filepath);
			XSSFWorkbook workbook=new XSSFWorkbook(fs);
			XSSFSheet objsheet=workbook.getSheet(Sheetname);
			
			
			
			int rowcount=objsheet.getLastRowNum();
			for(int i=1;i<=rowcount;i++)
			{	
				
				XSSFRow objrow=objsheet.getRow(i);
				String value=objrow.getCell(cellno).getStringCellValue();
				obja.add(value);
				
				//System.out.println(value);
						
			}
					
			workbook.close();
			fs.close();
			
			
		}
		
		catch(Exception e)
		{
			
			
			e.printStackTrace();
			
		}
		
		
		return obja;
	
	}
	
    
    
   
    
    
}
