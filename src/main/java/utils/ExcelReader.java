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
	
	
	
	
	

}
