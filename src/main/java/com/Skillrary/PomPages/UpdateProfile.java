package com.Skillrary.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateProfile {
	@FindBy(id="firstname")
	private WebElement firstnametb;
	
	@FindBy(name="addresstype")
	private WebElement addressdd;

	public WebElement getFirstnametb() {
		return firstnametb;
	}

	public WebElement getAddressdd() {
		return addressdd;
	}
	
	@FindBy(id="curr_password")
	private WebElement currentpassword;
	
	@FindBy(xpath="//Button[text()='Update']")
	private WebElement updateBtn;
	
	public UpdateProfile(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void firstname(String name) {
		firstnametb.sendKeys(name);
		
	}
	public void curentpasswordt(String pass) {
		currentpassword.sendKeys(pass);
		updateBtn.click();
	}

}
