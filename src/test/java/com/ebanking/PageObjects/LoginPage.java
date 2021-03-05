
	package com.ebanking.PageObjects;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LoginPage{
		 WebDriver ldriver;
		  public LoginPage(WebDriver rdriver)
		 {
			 ldriver=rdriver;
			 PageFactory.initElements(rdriver, this);
		 }
		 
		

		public LoginPage(String string) {
			// TODO Auto-generated constructor stub
		}



		@FindBy(xpath="(//a[@href='/register.php'])[1]")
		 WebElement Regclick;
		 
		 @FindBy(name="firstname")
		 WebElement firstname;
		 
		 @FindBy(name="lastname")
		 WebElement lastname;
		 public void setRegister()
		 {
			 Regclick.click();
		 }
		 public void firstName(String fn)
		 {
			 firstname.sendKeys(fn);
		 }
		 public void lastName(String ln)
		 {
			 lastname.sendKeys(ln);
		 }
		 

	}



