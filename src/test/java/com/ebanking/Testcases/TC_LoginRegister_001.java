
	package com.ebanking.Testcases;

	import org.testng.Assert;
	import org.testng.annotations.Test;

	import com.ebanking.PageObjects.LoginPage;
//import com.ebanking.PageObjects.RegisterPage;


	public class TC_LoginRegister_001 extends  BaseClass{
		
		@Test(priority = 0)
		public void registerTest()
		{
		driver.get(URL);
		logger.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setRegister();
		String fn = null;
		lp.firstName(fn);
		String ln = null;
		lp.lastName(ln);
		logger.info("click on register");

		if(driver.getTitle().contains("Register"))
		{
			Assert.assertTrue(true);
			logger.info("test passed");

		}
		else
		{
			Assert.assertTrue(false);
			logger.info("test failed");

		}
		}
		/* @Test(priority = 1)
		public void register()
		{
		RegisterPage reg=new RegisterPage(driver);
		reg.firstname("sushma");
		}*/

	}



