package crmPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crmBase.TestBase;

public class LoginPage extends TestBase {
	
	//PageFactory
	@FindBy(name = "email")
	@CacheLookup
	WebElement username;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//div[text() = 'Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Forgot your password?']")
	WebElement forgotPasswordBtn;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signupBtn;
	
	//Initializing page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String email, String pwd) {
		username.sendKeys(email);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	public SignUpPage signUp() {
		signupBtn.click();
		
		return new SignUpPage();
	}
	public ForgotPasswordPage forgotPassword() {
		forgotPasswordBtn.click();
		
		return new ForgotPasswordPage();
	}
}
