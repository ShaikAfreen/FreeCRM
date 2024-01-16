package crmPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crmBase.TestBase;

public class CreateNewContactPage extends TestBase {
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveBtn;
	@FindBy(xpath="//button[text()='Cancel']")
	WebElement cancelBtn;
	
	@FindBy(name="first_name")
	WebElement firstNameField;
	@FindBy(name="last_name")
	WebElement lastNameField;
	@FindBy(xpath="//div[@name='company']/input[@type='text']")
	WebElement companyNameField;
	@FindBy(xpath="//div[@name='category']/div[@role='alert']")
	WebElement categorySelectTextBox;
	
	//Initializing page object
	public CreateNewContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createNewContact(String fname, String lname, String companyname, String category) {
		
		firstNameField.sendKeys(fname);
		lastNameField.sendKeys(lname);
		companyNameField.sendKeys(companyname);
		categorySelectTextBox.click();
		driver.findElement(By.xpath("//div[@name='category' and @role='option']/span[text()='"+category+"']")).click();
		
		saveBtn.click();
		
		
	}
	
	public ContactsPage cancleCreateNewContact() {
		cancelBtn.click();
		
		return new ContactsPage();
	}
	
}
