package crmPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crmBase.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//div[@id='main-content']//span[text()='Contacts']")
	WebElement ContactsPageHeading;
	@FindBy(xpath="//a[@href='/contacts/new']")
	WebElement CreateNewContactBtn;
	
	//Initializing page object
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateContactsPageheading() {
		return ContactsPageHeading.getText();
	}
	
	public CreateNewContactPage clickCreateNewContactBtn() {
		CreateNewContactBtn.click();
		return new CreateNewContactPage();
	}
}
