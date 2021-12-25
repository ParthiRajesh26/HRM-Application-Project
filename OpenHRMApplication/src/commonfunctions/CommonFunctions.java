package commonfunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonFunctions {
	
	public static WebDriver driver=null;
	
	public static Properties properties=null;
	
	static Logger logger=Logger.getLogger(CommonFunctions.class);
	
	public Properties configFileProperties() throws IOException {
		
		FileInputStream fileInputStream=new FileInputStream("config.properties");
		
	    properties=new Properties();
		properties.load(fileInputStream);
		
		return properties;
		

		
	}
	
	
	@BeforeSuite
	public void openBrowser() throws IOException {
		
		PropertyConfigurator.configure("log4j.properties");
		
		logger.info("Starting Exicution of Orange HRM Application");
		
		logger.info("Getting properties Files");
		
		configFileProperties();
		
	String browser=	properties.getProperty("browser");
	String url=properties.getProperty("url");
	
	//String driverLocation=properties.getProperty("DriverLocation");
	
	if(browser.equalsIgnoreCase("chrome")) {
		//System.setProperty("webdriver.chrome.driver", driverLocation);
		
		logger.info("Launching The Chrome Browser");
		driver=new ChromeDriver();
		 
		
	} else if(browser.equalsIgnoreCase("firefox")) {
		//System.setProperty("webdriver.gecko.driver", driverLocation);
		
		logger.info("Launching The FireFox Browser");
		 driver=new FirefoxDriver();
			
		}
	
	driver.manage().window().maximize();
	
	logger.info("Navigating to the URL");
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
	}
		
	
	
	@AfterSuite
	public void closeBrowser() {
		
		logger.info("Teardown the Browser");
		driver.quit();
	}

}
