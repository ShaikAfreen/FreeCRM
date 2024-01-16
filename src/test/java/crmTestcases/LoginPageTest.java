package crmTestcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crmBase.TestBase;
import crmPages.ForgotPasswordPage;
import crmPages.HomePage;
import crmPages.LoginPage;
import crmPages.SignUpPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	SignUpPage signuppage;
	ForgotPasswordPage forgotpasswordpage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void validateLoginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void loginTest() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	@Test
	public void signUpTest() {
		signuppage = loginpage.signUp();
	}
	
	@Test
	public void forgotPasswordTest() {
		forgotpasswordpage = loginpage.forgotPassword();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
