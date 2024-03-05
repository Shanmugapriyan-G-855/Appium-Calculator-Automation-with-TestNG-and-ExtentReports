package org.sam;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;

public class TestNGcalculator {
	public static AndroidDriver driver;

	ExtentHtmlReporter htmlreporter;
	ExtentReports extent;
	ExtentTest test;

	@BeforeSuite
	private void launchBrowser() throws MalformedURLException {

		htmlreporter = new ExtentHtmlReporter("caclulator.html");

		extent = new ExtentReports();

		extent.attachReporter(htmlreporter);

		test = extent.createTest("Android", "calculator application");

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		cap.setCapability("deviceName", "Infinix Hot 10 Play");
		cap.setCapability("udid", "0619731191061108");
		cap.setCapability("appPackage", "com.transsion.calculator");
		cap.setCapability("appActivity", "com.transsion.calculator.Calculator");

		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver(url, cap);
	}

	@Test
	private void tc1() {

		test.log(Status.INFO, "appium click the eight button");
		driver.findElement(By.id("com.transsion.calculator:id/digit_8")).click();
		driver.findElement(By.id("com.transsion.calculator:id/op_add")).click();
		driver.findElement(By.id("com.transsion.calculator:id/digit_5")).click();
		driver.findElement(By.id("com.transsion.calculator:id/eq")).click();
	}

	@Test
	private void tc2() {
		test.log(Status.PASS, "appium click the add button");
		driver.findElement(By.id("com.transsion.calculator:id/op_add")).click();

	}

	@Test
	private void tc3() {
		test.log(Status.PASS, "appium click the six button");
		driver.findElement(By.id("com.transsion.calculator:id/digit_6")).click();
		driver.findElement(By.id("com.transsion.calculator:id/digit_0")).click();

	}

	@Test
	private void tc4() throws IOException {

		test.log(Status.PASS, "appium click the equal button");
		driver.findElement(By.id("com.transsion.calculator:id/eq")).click();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenShotAs = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("./Screenshot\\cal.png");
		FileUtils.copyFile(screenShotAs, f);
	}

	// @BeforeMethod
	// private void startDate() {
	// Date d = new Date();
	// System.out.println(d);

	// }

	// @AfterMethod
	// private void endDate() {
	// Date d = new Date();
	// System.out.println(d);

	// }

	@AfterSuite

	private void closeBrowser() {
		test.log(Status.PASS, "appium quit the apk");
		extent.flush();
		driver.quit();
	}
}
