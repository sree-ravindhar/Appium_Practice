package com.appiumm;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BrowserLaunch {
	
	
	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Sree");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
		cap.setCapability("chromedriverExecutable", ".\\Driver\\chromedriver.exe");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(url, cap);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/webhp?authuser=1");

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Sree Ravindhar");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		
		
		
	}

}
