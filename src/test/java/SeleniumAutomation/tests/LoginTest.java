package SeleniumAutomation.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import SeleniumAutomation.pageobjects.DashboardPage;
import SeleniumAutomation.pageobjects.LoginPage;

public class LoginTest extends BaseTest {
	
	public LoginPage loginPageObject;
	public DashboardPage dashboardPageObject;
	public Utils utilObject;
	public String email="admin@yourstore.com";
	public String password="admin";
	
	
	@Test(enabled=true)
	public void loginTest() throws InterruptedException {
		loginPageObject=new LoginPage(driver);
		dashboardPageObject=new DashboardPage(driver);
		loginPageObject.enterEmail(email);
		loginPageObject.enterPassword(password);
		loginPageObject.clickLogin();
		Thread.sleep(5);
		assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
		assertEquals(dashboardPageObject.getLoggedInUserName(), "John Smith");
		dashboardPageObject.clickLogout();
		Thread.sleep(5);
		assertEquals(driver.getTitle(), "Your store. Login");
	}
	
	@Test(enabled=true)
	public void loginTestWithPasswordOnly() {
		loginPageObject=new LoginPage(driver);
		utilObject=new Utils();
		loginPageObject.enterPassword(password);
		loginPageObject.clearDefaultEntryForEmail();
		loginPageObject.clickLogin();
		assertEquals(loginPageObject.getEmailValidationMessage(), "Please enter your email");
	}
	
	
	@Test(enabled=true)
	public void loginTestWithEmailOnly() throws InterruptedException {
		loginPageObject=new LoginPage(driver);
		loginPageObject.enterEmail(email);
		loginPageObject.clearDefaultEntryForPassword();
		loginPageObject.clickLogin();
		Thread.sleep(5);
		//System.out.println(loginPageObject.getLoginUnsuccessfulMessage());
		String message =loginPageObject.getLoginUnsuccessfulMessage();
		if(message.contains("Login was unsuccessful.") && message.contains("Please correct the errors and try again.") 
				&& message.contains("The credentials provided are incorrect") ) {
			assertEquals(false, false);
		}
		else {
			assertTrue(false);
		}
			
	}
	
	
	@Test(enabled=true)
	public void defaultUncheckRememberMe() {
		loginPageObject=new LoginPage(driver);
		loginPageObject.enterEmail(email);
		loginPageObject.enterPassword(password);
		assertEquals(loginPageObject.isCheckBoxSelected(loginPageObject.getElementRememberMe())
, false);
		
	}
	
	
	
	

}
