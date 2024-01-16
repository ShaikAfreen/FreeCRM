package crmBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import crmUtilities.TestUtil;
import crmUtilities.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	//public  static EventFiringDecorator<WebDriver> e_driver;
	//public static WebEventListener listeners;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\Eclipse\\eclipse docs\\FreeCRM\\src\\main\\java\\crmConfig\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}else if(browserName.equals("FF")) {
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver", "D:\\Eclipse\\FirefoxDriver\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		

		//listeners = new WebEventListener();
		//e_driver = new EventFiringDecorator<>(listeners);
		
		//driver = e_driver.decorate(driver);
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		driver.get(prop.getProperty("url"));
	}
	
}
