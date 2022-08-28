package com.appiumm;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class CuddlesTesting {

	public static void main(String[] args) throws MalformedURLException {

		File a = new File(".\\APK\\app-release.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Sree");

		cap.setCapability(MobileCapabilityType.APP, a.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");

		cap.setCapability("autoGrantPermissions", true);

		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(url, cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElementById("com.mahiti.cuddles22:id/sign_in_button").click();
		driver.findElementByXPath("//*[@text='Mahiti Test']").click();

		AndroidElement newChild = driver
				.findElementByXPath("//*[@resource-id='com.mahiti.cuddles22:id/cvAddNewChild']");
		newChild.click();
		driver.findElementByXPath("//*[@text='Full Name']").sendKeys("Sree Ravindhar");
		driver.findElementByXPath("//*[@text='Select..']").click();
		driver.findElementByXPath("//*[@text='Brother']").click();
		driver.findElementById("com.mahiti.cuddles22:id/edt_phone_no").sendKeys("8144954466");
		driver.findElementById("com.mahiti.cuddles22:id/edt_whatsapp_no").sendKeys("123456789");

	}
}
