package SeleniumAutomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnLogin;
	
	@FindBy(xpath="//span[@id='Email-error']")
	WebElement emailMandatoryMessage;
	
@FindBy(xpath="//div[@class='message-error validation-summary-errors']")
WebElement loginUnsuccessfulMessage;
	
	@FindBy(xpath="//li[normalize-space()='The credentials provided are incorrect']")
	WebElement credIncorrectMessage;
	
	@FindBy(xpath="//input[@id='RememberMe']")
	WebElement checkBoxRememberMe;
	
	public WebElement getElementRememberMe() {
		return checkBoxRememberMe;
	}
	
	public boolean isCheckBoxSelected(WebElement element) {
		return element.isSelected();
	}
	
	public String getLoginUnsuccessfulMessage() {
		return loginUnsuccessfulMessage.getText();
	}
	
	public String getCredIncorrectMessage() {
		return credIncorrectMessage.getText();
	}
	
	public String getEmailValidationMessage() {
		return emailMandatoryMessage.getText();
	}
	
	public void enterEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
		
	}
	
	public WebElement getWebElement(String element) {
		if(element.equalsIgnoreCase("email")) {
			return txtEmail;
			
		}
		else if(element.equalsIgnoreCase("password")) {
			return txtPassword;
		}
		return null;
	}
	
	public void clearDefaultEntryForEmail() {
		txtEmail.clear();
	}
	
	public void clearDefaultEntryForPassword() {
		txtPassword.clear();
	}
	
	public void enterPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}

}
