package com.appiumm;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	public static AndroidDriver<AndroidElement> driver;
	public static DesiredCapabilities cap;

	public static void appLaunch(String appPath) throws MalformedURLException {

		File a = new File(appPath);
		cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Sree");
		cap.setCapability(MobileCapabilityType.APP, a.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<>(url, cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public static void browserAppLaunch() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Sree");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability("chromedriverExecutable", ".\\Driver\\chromedriver.exe");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(url, cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

}
