package SeleniumAutomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement userName;

	@FindBy(xpath="//input[@id='userPassword']")
	WebElement userPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[@class='btn1']")
	WebElement registerPageButton;
	
	public void enterUserName(String uName) {
		userName.sendKeys(uName);
	}
	
	public void enterUserPassword(String uPassword) {
		userPassword.sendKeys(uPassword);		
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	   public void navigateToUserRegistrationPage() {
		   registerPageButton.click();
	   }
	   
	   public WebElement getRegisterButton() {
		   return registerPageButton;
		   
	   }
}
