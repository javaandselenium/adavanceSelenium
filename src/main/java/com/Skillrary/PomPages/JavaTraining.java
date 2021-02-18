package com.Skillrary.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaTraining {
	@FindBy(xpath="//div[@class='play-icon']")
    private WebElement playbtn;
	
	@FindBy(xpath="//div[@class='pause-icon']")
    private WebElement pausebtn;
	
	@FindBy(xpath="//a[text()=' TAKE THIS COURSE ']")
	private WebElement takecourse;
	
	public JavaTraining(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void playVideo() throws InterruptedException {
		playbtn.click();
		Thread.sleep(10000);
		pausebtn.click();
		
	}
	
	public void takeCouseBtn() {
		takecourse.click();
	}

}
