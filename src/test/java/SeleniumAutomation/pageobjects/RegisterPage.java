package SeleniumAutomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement firstNameTextBox;

	@FindBy(xpath="//input[@id='lastName']")
	WebElement lastNameTextBox;
	
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement emailIdTextBox;
	
	@FindBy(xpath="//input[@id='userMobile']")
	WebElement phoneNumberTextBox;

	@FindBy(xpath="//select[@class='custom-select ng-valid ng-dirty ng-touched']")
	WebElement occupationDropDown;
	
	@FindBy(xpath="//input[@value='Male']")
	WebElement genderMaleRadioButton;
	
	@FindBy(xpath="//input[@value='Female']")
	WebElement genderFemaleRadioButton;
	
	@FindBy(xpath="//input[@id='userPassword']")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//input[@id='confirmPassword']")
	WebElement confirmPasswordTextBox;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement eighteenYearOldCheckBox;
	
	@FindBy(xpath="//input[@value='Register']")
	WebElement registerButton;
	
	@FindBy(xpath="//div[contains(text(),'*First Name is required')]")
	WebElement firstNameValidation;
	
	@FindBy(xpath="//div[@aria-label='User already exisits with this Email Id!']")
	WebElement duplicateUserRegistrationMessage;
	
   public void enterFirstName(String fName) {
	   firstNameTextBox.sendKeys(fName);
   }
   public void enterLastName(String lName) {
	   lastNameTextBox.sendKeys(lName);
   }
   
   public void enterEmailID(String emailId) {
	   emailIdTextBox.sendKeys(emailId);
   }

   public void enterPhoneNumber(String pNumber) {
	   phoneNumberTextBox.sendKeys(pNumber);
	   
   }
   
   public void selectGender(String gender) {
	   if(gender.equalsIgnoreCase("Male")) {
		   genderMaleRadioButton.click();
	   }
	   else if (gender.equalsIgnoreCase("Female")) {
		   genderFemaleRadioButton.click();
	   }
   }
   
   public void enterPassword(String password) {
	   passwordTextBox.sendKeys(password);
   }
   
   public void confirmPassword(String conPassword) {
	   confirmPasswordTextBox.sendKeys(conPassword);
   }
   
   public void confirmEighteenYearOld(String yes) {
	   if (yes.equalsIgnoreCase("yes")) {
		   eighteenYearOldCheckBox.click();
	   }
   }
   
   public WebElement returnElementMessageForDuplicateEmailID() {
	return duplicateUserRegistrationMessage;
	   
   }
   
   public String getValidationMessageForDuplicateEmailID() {
	   return duplicateUserRegistrationMessage.getText();
   }
   
   public void clickRegister() {
	   registerButton.click();
   }
   

   
   public String getFirstNameValidationMessage() {
	   return firstNameValidation.getText();
   }

}
