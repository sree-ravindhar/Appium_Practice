package com.appiumm;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class SelendroidTest {
	
	public static void main(String[] args) throws MalformedURLException {
		
		
		File a = new File(".\\APK\\selendroid-test-app-0.17.0.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Sree");
		cap.setCapability(MobileCapabilityType.APP, a.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(url, cap);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		AndroidElement continueButton = driver.findElementByXPath("//*[@text='CONTINUE']");
		continueButton.click();
		
		
	

}
}
