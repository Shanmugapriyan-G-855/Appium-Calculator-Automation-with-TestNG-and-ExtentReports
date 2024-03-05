package org.sam;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class PropertiesFile {
	public static AndroidDriver driver;

	@Test
	private void tc1() throws InterruptedException, IOException {

		DesiredCapabilities cap = new DesiredCapabilities();

		Properties 	property = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\TestNG\\Files\\config.properties");
		property.load(fis);
		
		
		cap.setCapability("platformName", property.getProperty("platformName"));
		cap.setCapability("platformVersion", property.getProperty("version"));
		cap.setCapability("deviceName",property.getProperty("deviceName"));
		cap.setCapability("udid", property.getProperty("udid"));
		cap.setCapability("appPackage", property.getProperty("appPackage"));
		cap.setCapability("appActivity", property.getProperty("appActivity"));

		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver(url, cap);
		
		
		Thread.sleep(3000);
		WebElement add = driver.findElement(By.xpath(property.getProperty("add")));
		add.click();
		Thread.sleep(3000);
		WebElement name = driver.findElement(By.xpath(property.getProperty("name")));
		name.sendKeys(property.getProperty("firstName"));
		Thread.sleep(3000);
		WebElement phone = driver.findElement(By.xpath(property.getProperty("phone")));
		phone.sendKeys(property.getProperty("phoneNumber"));
		Thread.sleep(3000);
		WebElement save = driver.findElement(By.xpath(property.getProperty("save")));
		save.click();
	}
}
