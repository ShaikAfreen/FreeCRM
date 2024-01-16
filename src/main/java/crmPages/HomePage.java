package crmPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crmBase.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//span[contains(text() ,'Afreen  Shaik')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Home')]")
	WebElement homeBtn;
	
	@FindBy(xpath="//span[contains(text(),'Calendar')]")
	WebElement calenderBtn;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsBtn;
	
	@FindBy(xpath="//span[contains(text(),'Companies')]")
	WebElement companiesBtn;
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsBtn;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksBtn;
	
	@FindBy(xpath="//span[contains(text(),'Cases')]")
	WebElement casesBtn;
	
	@FindBy(xpath="//span[contains(text(),'Calls')]")
	WebElement callsBtn;
	
	@FindBy(xpath="//span[contains(text(),'Documents')]")
	WebElement documentsBtn;
	
	@FindBy(xpath="//span[contains(text(),'Email')]")
	WebElement emailBtn;
	
	//Initializing page object
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public CalenderPage clickOnCalendarPage() {
		calenderBtn.click();
		
		return new CalenderPage();
	}
	public ContactsPage clickOnContactsPage() {
		contactsBtn.click();
		
		return new ContactsPage();
	}
	public CompanyPage clickOnCompanyPage() {
		companiesBtn.click();
		
		return new CompanyPage();
	}
	public DealsPage clickOnDealsPage() {
		dealsBtn.click();
		
		return new DealsPage();
	}
	public TasksPage clickOnTasksPage() {
		tasksBtn.click();
		
		return new TasksPage();
	}
	public CasesPage clickOnCasesPage() {
		casesBtn.click();
		
		return new CasesPage();
	}
	public CallsPage clickOnCallsPage() {
		callsBtn.click();
		
		return new CallsPage();
	}
	public DocumentsPage clickOnDocumentsPage() {
		documentsBtn.click();
		
		return new DocumentsPage();
	}
	public EmailPage clickOnEmailPage() {
		emailBtn.click();
		
		return new EmailPage();
	}
	
	public boolean validateUserName() {
		return userNameLabel.isDisplayed();
	}
	
}
