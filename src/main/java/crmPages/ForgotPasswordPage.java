package crmPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crmBase.TestBase;

public class ForgotPasswordPage extends TestBase{

	@FindBy(xpath="//h2[contains(text(),'Forgot my password')]")
	WebElement pageHeading;
	
	@FindBy(name="email")
	WebElement emailField;
	
	@FindBy(xpath="//button[@type = 'submit']")
	WebElement resetPwdBtn;
	
	@FindBy(xpath="//a[contains(text(),'Log in')]")
	WebElement loginPageLink;
	
	//Initializing page object
	public ForgotPasswordPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage backToLoginPage() {
		loginPageLink.click();
		return new LoginPage();
	}
	
	public WebElement resetPassword() {
		emailField.sendKeys(prop.getProperty("username"));
		resetPwdBtn.click();
		WebElement thankYouMessage = driver.findElement(By.xpath("//*[normalize-space(text()) = 'Thank you. You will receive an email with a password reset link if this account is registered.']"));
		return thankYouMessage;
	}
		
}
