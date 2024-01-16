package crmTestcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crmBase.TestBase;
import crmPages.ContactsPage;
import crmPages.HomePage;
import crmPages.LoginPage;

public class ContactsPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage = homepage.clickOnContactsPage();
	}
	
	@Test
	public void validateContactsPageheadingTest() {
		 String contactsHeading = contactspage.validateContactsPageheading();
		 Assert.assertEquals(contactsHeading, "Contacts", "Contacts page Heading not Matched");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
