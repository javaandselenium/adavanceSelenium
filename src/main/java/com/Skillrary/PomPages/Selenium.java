package com.Skillrary.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Selenium {
	public WebDriver driver;
	@FindBy(xpath="//a[text()=' Core Java For Selenium Trainin']")
    private WebElement corejava;
	
	public Selenium(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public WebElement getCorejava() {
		return corejava;
	}

	public JavaTraining corejavacourse() {
		corejava.click();
		return new JavaTraining(driver);
	}
}
