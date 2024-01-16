package crmPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crmBase.TestBase;

public class SignUpPage extends TestBase {
	
	@FindBy(xpath = "//h2[text()='Register']")
	WebElement signUpPageheading;
	
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateSignUpPageHeading() {
		return signUpPageheading.getText();
	}

}
