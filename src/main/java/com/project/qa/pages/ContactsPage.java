package com.project.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.project.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLable;
	
	@FindBy(xpath = "//select[@name='title']")
	WebElement selectTitle;
	
	@FindBy(name = "first_name")
	WebElement firstName;
	
	@FindBy(name = "surname" )
	WebElement surName;
	
	@FindBy(name = "client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	
	public ContactsPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactLable() {
		return contactsLable.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
		+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title , String ftname,String ltName , String comp) {
		Select select = new Select(selectTitle);
		select.selectByValue(title);
		firstName.sendKeys(ftname);
		surName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
	}
}
