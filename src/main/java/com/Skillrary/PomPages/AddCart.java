package com.Skillrary.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author QSP
 *
 */
public class AddCart {
	/**
	 * Elements of addtocart
	 */
	@FindBy(id ="add")
	private WebElement plusbtn;

	@FindBy(xpath = "//button[text()=' Add to Cart']")
	private WebElement addtocart;
	
	public AddCart(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void addtocartBtn() {
		addtocart.click();
	}

	public WebElement getPlusbtn() {
		return plusbtn;
	}

	public WebElement getAddtocart() {
		return addtocart;
	}

}
