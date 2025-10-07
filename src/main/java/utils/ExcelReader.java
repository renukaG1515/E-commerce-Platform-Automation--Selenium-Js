


package utils;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
	
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
	
	
	// New method to read data from multiple columns
	
	public ArrayList<String> readColumn(String filePath, String sheetName, int cellNo) {
	        ArrayList<String> data = new ArrayList<>();

	        try {
	            FileInputStream fs = new FileInputStream(filePath);
	            XSSFWorkbook workbook = new XSSFWorkbook(fs);
	            XSSFSheet sheet = workbook.getSheet(sheetName);

	            int rowCount = sheet.getLastRowNum();
	            for (int i = 1; i <= rowCount; i++) {  // Skip header
	                XSSFRow row = sheet.getRow(i);
	                if (row != null && row.getCell(cellNo) != null) {
	                    String value = row.getCell(cellNo).getStringCellValue();
	                    data.add(value);
	                }
	            }

	            workbook.close();
	            fs.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return data;
	    }
}
	
	
	
	
