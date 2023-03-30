package com.project.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.project.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory - object repository // Create different Web element
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type = 'submit']" )
	WebElement loginbtn;
	
	@FindBy(linkText = "Sign Up" )
	WebElement signUpBtn;
	
	@FindBy(xpath  = "//img[contains(@class ,'img-responsive')]")
	WebElement crmLogo;
	
	//@FindBy(xpath = "//div[@aria-lable='Dismiss']")
	//@FindBy(xpath = "//div[@class='intercom-19gqqlk e13xul2n4']//span")
	//WebElement popUp;
	
	@FindBy(xpath = "//div[contains(@class,'e13xul2n4')]")
	WebElement popUp;
	
	//Initialize Page Object
	
	public LoginPage() {
		PageFactory.initElements(driver, this); //PageFactory.initElements(driver, LoginPage.class);
	}
	
	//Actions:
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un ,String pwd ) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click(); 
		
		return new HomePage(); // after clicking on login button it returns to Home page
	}
	
	public void popUpClose() {
		popUp.click();
	}
}
