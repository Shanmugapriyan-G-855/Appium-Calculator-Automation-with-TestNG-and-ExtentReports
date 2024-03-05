package org.sam;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AppiumCalculator {

	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion","11");
		cap.setCapability("deviceName", "Infinix Hot 10 Play");
		cap.setCapability("udid" ,"0619731191061108");
		cap.setCapability("appPackage" , "com.transsion.calculator");
		cap.setCapability("appActivity" , "com.transsion.calculator.Calculator");

		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver(url,cap);
		
		driver.findElement(By.id("com.transsion.calculator:id/digit_8")).click();
		driver.findElement(By.id("com.transsion.calculator:id/op_add")).click();
		driver.findElement(By.id("com.transsion.calculator:id/digit_5")).click();
		driver.findElement(By.id("com.transsion.calculator:id/eq")).click();
		
		
	
	
	
	}
	
	
}
