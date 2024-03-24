package SeleniumAutomation.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import SeleniumAutomation.pageobjects.DashboardPage;
import SeleniumAutomation.pageobjects.LoginPage;

public class LoginTest extends BaseTest {
	
	public LoginPage loginPageObject;
	public DashboardPage dashboardPageObject;
	public Utils utilObject;
	public String email="admin@yourstore.com";
	public String password="admin";
	
	
	@Test(enabled=false)
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
	
	@Test(priority = 1,timeOut = 5000)
	public void loginTestWithPasswordOnly() {
		loginPageObject=new LoginPage(driver);
		utilObject=new Utils();
		loginPageObject.enterPassword(password);
		loginPageObject.clearDefaultEntryForEmail();
		loginPageObject.clickLogin();
		assertEquals(loginPageObject.getEmailValidationMessage(), "Please enter your email");
	}
	
	
	@Test(priority = 1)
	@Parameters({"passwordfromxml"})
	public void loginTestWithPasswordOnlyParams(String passwordfromxml) {
		loginPageObject=new LoginPage(driver);
		utilObject=new Utils();
		loginPageObject.enterPassword(passwordfromxml);
		loginPageObject.clearDefaultEntryForEmail();
		loginPageObject.clickLogin();
		assertEquals(loginPageObject.getEmailValidationMessage(), "Please enter your email");
	}
	
	@Test(priority = 1,invocationCount = 2)
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
	
	
	@Test(dependsOnMethods = "loginTestWithEmailOnly",groups="login functinality")
	public void defaultUncheckRememberMe() {
		loginPageObject=new LoginPage(driver);
		loginPageObject.enterEmail(email);
		loginPageObject.enterPassword(password);
		assertEquals(loginPageObject.isCheckBoxSelected(loginPageObject.getElementRememberMe())
, false);
		
		
	}

	
	@DataProvider(name="Login Credentials",parallel = false)
	private Object[][] loginCredentials() {
		// TODO Auto-generated method stub
		Object[][] data = new Object[2][2];
		data[0][0]="admin@yourstore.com";
		data[0][1]="admin";
		
		data[1][0]="admin@yourstore.com";
		data[1][1]="admin";
		
		return data;
		
	}
	
	
	@Test(dataProvider = "Login Credentials")
	public void loginTestWithDataPro(String em,String pw)  throws InterruptedException {
		loginPageObject=new LoginPage(driver);
		dashboardPageObject=new DashboardPage(driver);
		Reporter.log("loginTestWithDataPro has started with value" +em +pw);
		loginPageObject.enterEmail(em);
		loginPageObject.enterPassword(pw);
		loginPageObject.clickLogin();
	}
	
	
	

}
