package crmTestcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import crmBase.TestBase;
import crmPages.ContactsPage;
import crmPages.CreateNewContactPage;
import crmPages.HomePage;
import crmPages.LoginPage;
import crmUtilities.TestUtil;

public class CreateNewContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	CreateNewContactPage createnewcontactspage;
	String sheetName = "contacts";
	
	public CreateNewContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage = homepage.clickOnContactsPage();
		createnewcontactspage = contactspage.clickCreateNewContactBtn();
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object[][] data = null;
		try {
			data = TestUtil.getTestData(sheetName);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return data;
	}
	
	@Test(dataProvider="getCRMTestData")
	public void createNewContactTest(String firstName, String lastName, String company, String category) {
		createnewcontactspage.createNewContact(firstName, lastName, company, category);
	}
	
	@Test
	public void cancleCreateNewContactTest() {
		createnewcontactspage.cancleCreateNewContact();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
