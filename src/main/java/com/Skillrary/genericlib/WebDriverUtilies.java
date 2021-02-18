package com.Skillrary.genericlib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import sun.util.calendar.BaseCalendar.Date;

/**
 * 
 * @author QSP
 *
 */
public class WebDriverUtilies {
	/**
	 * To read the data from propertyfile
	 * 
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	public String getPropertyData(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileInputStream(Autoconstant.propertyFilepath));
		return p.getProperty(key);
	}

	/**
	 * To readthe data from excel sheet
	 * 
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @throws InvalidFormatException 
	 */

	public String getExcelData(String sheetname, int rownum, int cellnum)
			throws EncryptedDocumentException, IOException, InvalidFormatException {
		FileInputStream f = new FileInputStream(Autoconstant.excelFilepath);
		Workbook wb = WorkbookFactory.create(f);
		return wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();

	}

	/**
	 * To Handle the mouseHover
	 * 
	 * @param driver
	 * @param ele
	 */

	public void mouseHover(WebDriver driver, WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
	}

	/**
	 * To handle the double click
	 * 
	 * @param driver
	 * @param ele
	 */

	public void doubleClick(WebDriver driver, WebElement ele) {
		Actions a = new Actions(driver);
		a.doubleClick(ele).perform();
	}

	/**
	 * To handle the alert popup
	 * 
	 * @param driver
	 */

	public void alert(WebDriver driver) {
		
		driver.switchTo().alert().accept();
	
	}
	/**
	 * To verify 
	 * @param actual
	 * @param expected
	 * @param page
	 */
	
	public void verify(String actual,String expected,String page) {
		Assert.assertEquals(actual, expected);
		Reporter.log(page +" Is dispalyed ",true);
	}
	/**
	 * Switching frame
	 * @param driver
	 */
	
	public void switchFrame(WebDriver driver) {
		driver.switchTo().frame(0);
	}
	
	/**
	 * Switching back to default page
	 * @param driver
	 */
	public void switchbackframe(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * switch the tabs
	 * @param driver
	 */
	public void switchtab(WebDriver driver) {
		Set<String> child = driver.getWindowHandles();
		for(String b:child)
		{
			driver.switchTo().window(b);
		}
	}

	public void fileupload(String path) throws IOException {
		Runtime.getRuntime().exec(path);
	}
	
	public void dropDown(WebElement ele,String text) {
		Select s=new Select(ele);
		s.selectByVisibleText(text);
	}

}
