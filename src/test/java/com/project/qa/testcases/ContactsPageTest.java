package com.project.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.qa.base.TestBase;
import com.project.qa.pages.ContactsPage;
import com.project.qa.pages.DealsPage;
import com.project.qa.pages.HomePage;
import com.project.qa.pages.LoginPage;
import com.project.qa.pages.TaskPage;
import com.project.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetname = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		intialization();
		homepage = new HomePage();
		testUtil  = new TestUtil();
		contactsPage = new ContactsPage();
		loginpage = new LoginPage();
		testUtil.switchToLoginFrame();
		loginpage.popUpClose();
		testUtil.switchToMain();
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil.switchToFrame();
		homepage.clickOnContactsLink();
	}
	
	@Test(priority = 1)
	public void verifyContactsPageLable() {
		Assert.assertTrue(contactsPage.verifyContactLable(),"Contact lable is missing on this page");
	}
	
	@Test(priority = 2)
	public void selectSingleContactTest() {
		contactsPage.selectContactsByName("annu annu");
	}
	
	@Test(priority = 3)
	public void selectMultipleContactList() {
		contactsPage.selectContactsByName("annu annu");
		contactsPage.selectContactsByName("anu patel");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][]=TestUtil.getTestData(sheetname);
		return data;
	}
	
	@Test(priority = 4,dataProvider = "getCRMTestData" )
	public void validateCreateContact(String title, String fname , String lname , String cmpny) {
		homepage.clickOnNewContactLink();
		//contactsPage.createNewContact("Miss","nina", "bandu", "golu");
		contactsPage.createNewContact(title,fname,lname,cmpny);
		//You can assert that data is added or not on that page like go to contact page and see name available or not
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
