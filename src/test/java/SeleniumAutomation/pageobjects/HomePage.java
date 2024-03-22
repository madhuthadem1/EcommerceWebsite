package SeleniumAutomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='btn w-10 rounded']")
	WebElement addButtonCoat;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement ordersButton;
	
	@FindBy(xpath="//button[normalize-space()='Sign Out']")
	WebElement signOut;
	
	@FindBy(xpath="//div[@class='py-2 border-bottom ml-3']//input[@placeholder='search']")
	WebElement searchItemTextBox;
	
	@FindBy(xpath="//button[@class='btn w-10 rounded']")
	WebElement itemZaraCoatAddToCart;
	
	@FindBy(xpath="//div[@aria-label='Product Added To Cart']")
	WebElement addedToCartMessage;
	
	By addedToCartMessage2 = By.xpath("//div[@aria-label='Product Added To Cart']");
	
	public By returnElementAddedToCartMessage() {
		return addedToCartMessage2;
	}
	
	public String getAddedToCartSuccessMessage() {
		return addedToCartMessage.getText();
	}
	
	
	public void addItemToCart(String item) {
		if(item.equalsIgnoreCase("ZARA COAT 3")) {
			itemZaraCoatAddToCart.click();
		}
	}
	
	public void goToOrdersPage(WebDriver driver) {
		ordersButton.click();
	}
	
   public void userSignOut() {
	   signOut.click();
   }
   
   public WebElement signOutButton() {
	return signOut;
	   
   }
   public void searchForItem(String itemName) {
	   searchItemTextBox.sendKeys(itemName);
	   
   }
   


}
