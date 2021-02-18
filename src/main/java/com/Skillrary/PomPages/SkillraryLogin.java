package com.Skillrary.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillraryLogin {
public WebDriver driver;
	@FindBy(name="q")
	private WebElement serachtb;
	
	@FindBy(xpath="//input[@value='go']")
	private WebElement go;
	
	@FindBy(xpath="//a[text()=' GEARS ']")
	private WebElement gearsBtn;
	
	@FindBy(xpath="(//a[text()=' SkillRary Demo APP'])[2]")
	private WebElement demoApp;
	
	public SkillraryLogin(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public WebElement getSerachtb() {
		return serachtb;
	}

	public WebElement getGo() {
		return go;
	}
	
	public SkillraryDemoLogin demoApp() {
		gearsBtn.click();
		demoApp.click();
		return new SkillraryDemoLogin(driver);
	}

	public Selenium serachForCourse(String coursename) {
		serachtb.sendKeys(coursename);
		go.click();
		return new Selenium(driver);
	}
	
}
