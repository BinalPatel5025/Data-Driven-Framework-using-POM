package com.project.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.project.qa.base.TestBase;
import com.project.qa.pages.HomePage;
import com.project.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest() {
		super(); /*
		 * reference variable that is used to refer parent class constructors.If we now
		 * define this that it will give null pointer exception because we have already
		 * define properties, call TestBase() method from TestBase Class
		 */
	}

	@BeforeMethod
	public void setUp() {
		intialization();
		loginpage = new LoginPage(); //create object of loginpage class
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		log.info("*********************Checking Title of Login Page*********************");
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
	}
	
	@Test(priority = 2)
	public void crmLogoImgTest() {
		boolean flag =  loginpage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginTest() {
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
