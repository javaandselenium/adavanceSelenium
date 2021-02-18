package com.Skillrary.PomPages;
/**
 * 
 * @author QSP
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author QSP
 *
 */
public class SkillraryDemoLogin {
	public WebDriver driver;
	/**
	 * Elements of login  page
	 */
	@FindBy(id="course")
	private WebElement courseTab;
	
	@FindBy(xpath="//a[text()='Selenium Training']")
	private WebElement seleniumTainingOption;
	
	@FindBy(xpath="//a[text()='LOGIN']")
	private WebElement signInbtn;
	
	@FindBy(id="email")
	private WebElement emailtb;
	
	@FindBy(id="password")
	private WebElement passwordtb;
	
	@FindBy(name="login")
	private WebElement loginbtn;
	
	public SkillraryDemoLogin(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}


	public WebElement getCourseTab() {
		return courseTab;
	}

	public WebElement getSeleniumTainingOption() {
		return seleniumTainingOption;
	}
	
	public AddCart clickCource() {
		seleniumTainingOption.click();
		return new AddCart(driver);	
	}
	
	public void logincredentail(String email,String password) {
		signInbtn.click();
		emailtb.sendKeys(email);
		passwordtb.sendKeys(password);
		loginbtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
