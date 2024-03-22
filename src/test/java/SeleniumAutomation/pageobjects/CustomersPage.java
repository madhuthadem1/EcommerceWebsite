package SeleniumAutomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage {

	WebDriver driver;
	
	public CustomersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement btnAddNew;
	
	@FindBy(xpath="//button[@name='save']//i[@class='far fa-save']")
	WebElement btnSave;
	
	@FindBy(xpath="//div[@class='validation-summary-errors']//li[1]")
	WebElement txtEmailMessage;
	
	public String getEmailMustMessage() {
		return txtEmailMessage.getText();
	}
	
	public void saveDetails() {
		btnSave.click();
	}
	
	public void openAddNewCustomerPage() {
		btnAddNew.click();
	}
	
}
