package com.Skillrary.genericlib;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import javax.imageio.spi.ImageTranscoderSpi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Skillrary.PomPages.SkillraryDemoLogin;
import com.Skillrary.PomPages.SkillraryLogin;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
/**
 * 
 * @author QSP
 *
 */
public class Baseclass {
	/**
	 * Open the application
	 */
	public WebDriver driver;
	public WebDriverUtilies utilies=new WebDriverUtilies();
	public ExtentHtmlReporter htmlreport;
	public static ExtentReports reports;
	public static ExtentTest test;
	public Photo p;
	public SkillraryDemoLogin l;
	public static Connection con;
	public  FileUtilies f=new FileUtilies();
	

	
	@BeforeSuite
	public void configBS() throws SQLException {
		con=FileUtilies.getDataDb();


	 htmlreport=new ExtentHtmlReporter(Autoconstant.reportspath);
	 htmlreport.config().setDocumentTitle("SkillRaryReports");
	 htmlreport.config().setTheme(Theme.DARK);
	 reports=new ExtentReports();
	 reports.attachReporter(htmlreport);
	 
		
	}
	
//	@BeforeClass
//	public void configBC(String browser) throws FileNotFoundException, IOException {
//		if(browser.equals("chrome")) {
//			ChromeDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//		}
//		else {
//			FirefoxDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();
//		}
//		driver.get(utilies.getPropertyData("url"));
//	}
	
	
	
	@BeforeMethod
	public void configBM() throws FileNotFoundException, IOException {
		ChromeDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(f.getPropertyData("url"));
		driver.manage().window().maximize();
		utilies=new WebDriverUtilies();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		SkillraryLogin s=new SkillraryLogin(driver);
		l = s.demoApp();
		
	}
	/**
	 * close the application
	 * @throws IOException 
	 */
	
	@AfterMethod
	public void closeapp(ITestResult r) throws IOException {
		int result = r.getStatus();
	if(result==ITestResult.FAILURE) {
		test.log(Status.FAIL,r.getName()+"Test case failed");
		test.log(Status.FAIL,r.getThrowable()+"Test case failed exception");
		Photo p=new Photo();
		test.addScreenCaptureFromPath(p.screenshot(driver,r.getName()));
	}
	else if(result==ITestResult.SUCCESS) {
		test.log(Status.PASS,r.getName()+"Test case passed");
		
	}
	else if(result==ITestResult.SKIP) {
		test.log(Status.SKIP,r.getName()+"Test case skipped");
	}
	
		
	}
	
//	@AfterClass
//	public void configAC() {
//		driver.quit();
//	}
//	
	@AfterSuite
	public void configAS() throws SQLException {
		
		htmlreport.flush();
		reports.flush();
		FileUtilies.closedb();
		
		
	}
	

}
