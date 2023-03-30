package com.project.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.project.qa.util.TestUtil;
import com.project.qa.util.WebEventListener;

public class TestBase {

	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Selenium_WorkSpace\\POM_Test\\src\\main\\java\\com\\project\\qa\\config\\config.properties");
			prop.load(ip);
		
		}catch (IOException e) {
			e.getMessage();
		}
		
}
	
	public static void intialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver","C:\\SeleniumJars\\msedgedriver.exe");
			driver = new ChromeDriver();
		}else{
			System.setProperty("webdriver.gecko.driver","C:\\SeleniumJars\\geckodriver.exe");
			driver = new ChromeDriver();
			}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		
		driver.get(prop.getProperty("url"));
	}
}
