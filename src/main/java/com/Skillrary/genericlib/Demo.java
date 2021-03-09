package com.Skillrary.genericlib;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Demo {

	public static void main(String[] args) {
	DesiredCapabilities d=new DesiredCapabilities();
	d.setCapability("automationName","Appium");
	d.setCapability("platformName","Android");
	d.setCapability("deviceName","Sam2");
	d.setCapability("appPacakage","");
	d.setCapability("appActivity","");
	URL url=new URL("http://127.0.0.1:4723/wd/hub");
	AndroidDriver driver=new AndroidDriver(url,d);
	
	

	}

}
