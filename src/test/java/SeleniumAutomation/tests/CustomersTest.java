package SeleniumAutomation.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import SeleniumAutomation.pageobjects.CustomersPage;
import SeleniumAutomation.pageobjects.DashboardPage;
import SeleniumAutomation.pageobjects.LoginPage;

public class CustomersTest extends BaseTest {
	
	public LoginPage loginPageObject;
	public DashboardPage dashboardPageObject;
	public CustomersPage customersPageObject;
	public String email="admin@yourstore.com";
	public String password="admin";
	
	@Test
	public void addCustomer() throws InterruptedException {
		
		loginPageObject=new LoginPage(driver);
		dashboardPageObject=new DashboardPage(driver);
		customersPageObject=new CustomersPage(driver);
		loginPageObject.enterEmail(email);
		loginPageObject.enterPassword(password);
		loginPageObject.clickLogin();
		Thread.sleep(5);
		dashboardPageObject.clickExpandCustomersLink();
		Thread.sleep(5);
		dashboardPageObject.naviagetToCustomersPage();
		Thread.sleep(5);
		customersPageObject.openAddNewCustomerPage();
	}
	
	@Test
	public void emailValidationWhileAddingCustomer() throws InterruptedException {
		
		loginPageObject=new LoginPage(driver);
		dashboardPageObject=new DashboardPage(driver);
		customersPageObject=new CustomersPage(driver);
		loginPageObject.enterEmail(email);
		loginPageObject.enterPassword(password);
		loginPageObject.clickLogin();
		Thread.sleep(5);
		dashboardPageObject.clickExpandCustomersLink();
		Thread.sleep(5);
		dashboardPageObject.naviagetToCustomersPage();
		Thread.sleep(5);
		customersPageObject.openAddNewCustomerPage();
		customersPageObject.saveDetails();
		Thread.sleep(5);
		assertEquals(customersPageObject.getEmailMustMessage(), "'Email' must not be empty.");
	}
	
}
