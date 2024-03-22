package SeleniumAutomation.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import SeleniumAutomation.pageobjects.HomePage;
import SeleniumAutomation.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public Properties prop;
	public LandingPage landingPage;
	public HomePage homePage;
	public ChromeOptions options;
	
	public WebDriver initializeDriver() throws IOException {
		
		System.out.println("line30");
		prop = new Properties();
		System.out.println("line32");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//SeleniumAutomation//resources//GlobalData.properties");
	    prop.load(fis);
	    System.out.println("line35");
	    String browserName="chrome";
	    System.out.println("line37");
	 // browserName =System.getProperty("browser")!=null ? System.getProperty("browser"): prop.getProperty("browser");
	  //  browserName =prop.getProperty("browser");
	    
	    if(browserName.equals("chrome")) {
	    	System.out.println("line42");
	    	//WebDriverManager.chromedriver().setup();
	    	System.setProperty("webdriver.chrome.driver", "C://Java workspace//EcommerceWebsite//Drivers//chromedriver.exe");
	    	System.out.println("line44");
	    	options=new ChromeOptions();
	    	options.addArguments("headless");
	    	//driver = new ChromeDriver(options);
	    	driver = new ChromeDriver();
	    	System.out.println("line46");
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    	driver.manage().window().maximize();
	    }
	    
	    else if(browserName.equals("firefox")){
	    	WebDriverManager.firefoxdriver().setup();
	    	driver = new FirefoxDriver();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    	driver.manage().window().maximize();
	    }
	    return driver;
	}
	
	@BeforeMethod 
    public LandingPage launchApplication() throws IOException {
		System.out.println("line62");
    	driver = initializeDriver();
    	System.out.println("line64");
    	landingPage = new LandingPage(driver);
    	System.out.println("line65");
    	driver.get(prop.getProperty("appURL2"));
    	System.out.println("line68");
    	return landingPage;
    	
    }
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//Reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		//return System.getProperty(("user.dir")+"//Reports//"+testCaseName+".png");
//		System.out.println("getAbsolutePath "+file.getAbsolutePath());
//		System.out.println("file.getName() "+file.getName());
//		System.out.println(System.getProperty(("user.dir")));
		//return System.getProperty(("user.dir")+"//Reports//"+file.getName()+".png");
		return file.getAbsolutePath();
	
	}

}
