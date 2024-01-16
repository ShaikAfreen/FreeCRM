package crmTestcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crmBase.TestBase;
import crmPages.HomePage;
import crmPages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	@Test
	public void validateUserNameTest() {
		Assert.assertTrue(homepage.validateUserName());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
