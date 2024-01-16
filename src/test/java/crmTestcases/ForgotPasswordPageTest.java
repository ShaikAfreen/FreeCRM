package crmTestcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crmBase.TestBase;
import crmPages.ForgotPasswordPage;
import crmPages.LoginPage;

public class ForgotPasswordPageTest extends TestBase {

	ForgotPasswordPage forgotpasswordpage;
	LoginPage loginpage;
	
	public ForgotPasswordPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test
	public void backToLoginPageTest() {
		forgotpasswordpage = loginpage.forgotPassword();
		loginpage = forgotpasswordpage.backToLoginPage();		
	}
	@Test
	public void resetPasswordTest() {
		forgotpasswordpage = loginpage.forgotPassword();
		WebElement thankyouMsg = forgotpasswordpage.resetPassword();	
		Assert.assertEquals(thankyouMsg.getText(), "Thank you. You will receive an email with a password reset link if this account is registered.");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
