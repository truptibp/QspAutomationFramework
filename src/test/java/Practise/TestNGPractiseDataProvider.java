package Practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGPractiseDataProvider 
{
	@Test(dataProvider="getData")
	public void createSample(String name,int id)
	{
		System.out.println("Name is -" + name +" and Id is - " +id);
	}
	
	//create customer -create emp data -dataprovider
	
	@DataProvider
	public Object[][] getData()
	{ 
		// 3 row -3 data sets  and each has 2 columns- 2 information
		Object[][]data =new Object[3][2];
		
		//1st Data set
		data[0][0]="Trupti";
		data[0][1]=12;
		
		//2nd data set
		data[1][0]="Avaneesh";
		data[1][1]=15;
		
		//3rd data set
		data[2][0]="john";
		data[2][1]=8;
		
		return data;
		
	}

}
