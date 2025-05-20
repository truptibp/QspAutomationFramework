package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to properties file (CommonData.properties) of file operations.
 */
public class FileUtility 
{
	/**
	 * This method will read data from properties file(CommonData.properties) and return the value.
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	public String readDataFromPropertfile(String key) throws IOException 
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}
	
	/**
	 * This method will return data from excel file and return value.
	 * @param sheetname
	 * @param rowNo
	 * @param cellno
	 * @return PRODUCTNAME
	 * @throws IOException
	 */
	
	public String readDataFromExcel(String sheetname,int rowNo,int cellno) throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestDataForAutomation.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row rw=sh.getRow(rowNo);
		Cell cl=rw.getCell(cellno);
		String PRODUCTNAME=cl.getStringCellValue();
		return PRODUCTNAME;
		
		
		
		
	}

}
