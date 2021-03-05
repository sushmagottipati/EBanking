package com.ebanking.Testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ebanking.PageObjects.LoginPage;
import com.ebanking.Utilities.XLUtils;

public class TC_loginDDT_002 extends BaseClass{
	@Test(dataProvider = "data")
	public void loginDDT(String fn,String ln)
	{
		LoginPage lp=new LoginPage("driver");
		lp.firstName(fn);
		lp.lastName(ln);
		
		
		
	}
	
	@DataProvider(name="data")
	String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/ebanking/TestData/data.xlsx";
		int rownum=XLUtils.getRowCount(path, "sheet1");
		int colcount=XLUtils.getCellCount(path, "sheet1", 1);
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
				
			}
		}
		return logindata;
		
	}
	

}
