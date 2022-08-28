package com.appiumm;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class TouchActionExample extends BaseClass{
	
	
	public static void main(String[] args) throws MalformedURLException {
		
		appLaunch("D:\\My data\\Java\\AppiumClass\\APK\\ApiDemos-debug.apk");
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Views\"]").click();
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]").click();
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]").click();
		WebElement people = driver.findElementByXPath("//*[@text='People Names']");
		TouchAction a = new TouchAction<>(driver);
		a.longPress(LongPressOptions.longPressOptions()
				.withElement(ElementOption.element(people))
				.withDuration(Duration.ofSeconds(2))).release().perform();
		
	}

}
