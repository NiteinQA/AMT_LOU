package com.amt.testBase;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.amt.pages.LoginPage;
import com.amt.testUtil.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
    public static Properties prop;
    public static Logger LO;
    LoginPage obj_Login_Page;
	
    public TestBase() {
    	try
    	{
    		prop=new Properties();
    		FileInputStream ip = new FileInputStream("D:\\LOU\\AMT_LOU\\src\\main\\java\\configs\\config.properties");
    		prop.load(ip);                            
    	}
    	catch(FileNotFoundException e)
    	{
    		e.printStackTrace();
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    }
 
	
	 
	 
	public static void initialization(String browser) throws InterruptedException {

		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver","D:\\chromedriver-win64\\chromedriver.exe");
			//WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
		
		
		
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("force-device-scale-factor=0.67");
			options.addArguments("high-dpi-support=0.67");
//			options.addArguments("--headless=new");
			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			
			
			//WebDriverManager.edgedriver().setup();
			
			
			System.setProperty("webdriver.edge.driver", "D:\\msedgedriver.exe");			
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			
			driver = new EdgeDriver(options);

		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));

		driver.get(prop.getProperty("url"));
	}
	
	
	@BeforeTest
	public void start_info() throws InterruptedException, IOException {

		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"D:\\LOU\\AMT_LOU\\src\\main\\java\\configs\\config.properties");
		prop.load(ip);


		
		System.out.println("Welcome to the AMT Automation");
		System.out.println("");
		System.out.println("We are running suite on "+prop.getProperty("browser")+" browser");
		System.out.println("");
		System.out.println("Url of the enviroment is "+prop.getProperty("url"));
		System.out.println("");

	}
	
	@BeforeClass
	public void setup() throws InterruptedException, IOException {
     
		prop=new Properties();
		FileInputStream ip = new FileInputStream("D:\\LOU\\AMT_LOU\\src\\main\\java\\configs\\config.properties");
		prop.load(ip);		
		  
	    initialization(prop.getProperty("browser"));
	 
		obj_Login_Page = new LoginPage();
		obj_Login_Page.enter_credentials();
	}

 // @AfterClass public void tearDown() { driver.close(); }
	
	
	}
