package com.Skillrary.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Profile {
	public WebDriver driver;
	@FindBy(xpath="//span[text()='Harry Den']")
	private WebElement proilename;
	
	@FindBy(xpath="//a[text()='Profile']")
	private WebElement profilebtn;
	
	@FindBy(xpath="//a[text()=' Edit']")
	private WebElement editbtn;
	
	public Profile(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public UpdateProfile editProfile() {
		proilename.click();
		profilebtn.click();
		editbtn.click();
		return new UpdateProfile(driver);
	}

}
