package com.appiumm;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class FirstProgram extends BaseClass {  

	public static void main(String[] args) throws MalformedURLException {
		
		appLaunch(".\\APK\\ApiDemos-debug.apk");
		
		AndroidElement preference = driver.findElementByAndroidUIAutomator("text(\"Preference\")");
		preference.click();
		AndroidElement goToWifi = driver.findElementByXPath("//*[@text='3. Preference dependencies']");
		goToWifi.click();
		AndroidElement checkBox = driver.findElementById("android:id/checkbox");
		checkBox.click();
		AndroidElement settings = driver.findElementByXPath("(//android.widget.RelativeLayout)[2]");
		settings.click();
		AndroidElement nameText = driver.findElementById("android:id/edit");
		nameText.sendKeys("It-Worked");
		driver.findElementByXPath("//*[@text='OK']").click();
		
		
		
		
		
		
		
		
		
		
	}

}
