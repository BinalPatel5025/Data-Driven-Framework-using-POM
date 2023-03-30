package com.project.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.project.qa.base.TestBase;
import com.project.qa.pages.ContactsPage;
import com.project.qa.pages.DealsPage;
import com.project.qa.pages.HomePage;
import com.project.qa.pages.LoginPage;
import com.project.qa.pages.TaskPage;
import com.project.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	DealsPage dealspage;
	TaskPage taskpage;
	public HomePageTest() {
		super();
	}
	

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		intialization();
		loginpage = new LoginPage();
		testUtil  = new TestUtil();
		contactsPage = new ContactsPage();
		dealspage = new DealsPage();
		taskpage = new TaskPage();
		
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void homePageTitle() {
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"CRMPRO","Home Page Title Not Match");
	}
	
	@Test(priority = 2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame(); 
		Assert.assertTrue(homepage.verifyUserName()); 
	}
	
	@Test(priority = 3)
	public void verifyContactslinkTest() {
		testUtil.switchToFrame(); 
		contactsPage = homepage.clickOnContactsLink();
	}
	
	@Test(priority = 3)
	public void verifyDealsslinkTest() {
		testUtil.switchToFrame(); 
		dealspage = homepage.clickOnDealsLink();
	}
	
	@Test(priority = 3)
	public void verifyTaskslinkTest() {
		testUtil.switchToFrame(); 
		taskpage = homepage.clickOnTaskLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
