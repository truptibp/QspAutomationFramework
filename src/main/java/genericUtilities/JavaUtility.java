package genericUtilities;


import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtility {

	/**
	 * This method will capture current system date and return to caller. 
	 * @return dataInFormat
	 */
	
	public String getSystemDate()
	{
		Date d=new Date();
		SimpleDateFormat f=new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String dataInFormat = f.format(d);
		
		return dataInFormat;
	}

}
