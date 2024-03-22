package SeleniumAutomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement btnLogout;
	
	@FindBy(xpath="//nav[@class='main-header navbar navbar-expand-md navbar-dark bg-dark']//li[2]")
	WebElement readOnlyUsername;
	
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement expandCustomers;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']")
	WebElement btnCustomers;
	
	public void naviagetToCustomersPage() {
		btnCustomers.click();
	}
	
	
	public void clickExpandCustomersLink() {
		expandCustomers.click();
	}
	
	public void clickLogout() {
		btnLogout.click();
	}
	
	public String getLoggedInUserName() {
		
		return readOnlyUsername.getText();
	}
	
}
