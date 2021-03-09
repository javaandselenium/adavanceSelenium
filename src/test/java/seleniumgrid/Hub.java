package seleniumgrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Hub {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		URL remoteAddress=new URL("http://192.168.0.100:4444/wd/hub");
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
		WebDriver driver=new RemoteWebDriver(remoteAddress, capabilities);
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("phone");
		Thread.sleep(3000);
		driver.close();
	}

}
