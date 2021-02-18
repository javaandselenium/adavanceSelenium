package com.Skillrary.genericlib;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Photo {
	public String screenshot(WebDriver driver,String name) throws IOException {
		Date d=new Date();
		String date = d.toString().replaceAll(":", "-");

		TakesScreenshot t =(TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		String path=Autoconstant.photopath + date +name+ ".png";
		File dest = new File(path);
	FileUtils.copyFile(src, dest);
	return path;
	}
}
