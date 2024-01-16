package crmTestcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crmBase.TestBase;
import crmPages.LoginPage;
import crmPages.SignUpPage;

public class SignUpPageTest extends TestBase{
	
	SignUpPage signuppage;
	LoginPage loginpage;
	
	public SignUpPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test
	public void validateSignUpPageHeadingTest() {
		signuppage = loginpage.signUp();
		String pageHeading = signuppage.validateSignUpPageHeading();
		Assert.assertEquals(pageHeading, "Register");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
