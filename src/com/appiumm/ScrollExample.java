package com.appiumm;

import java.net.MalformedURLException;

public class ScrollExample extends BaseClass{

	public static void main(String[] args) throws MalformedURLException {
		
		
		appLaunch(".\\APK\\\\ApiDemos-debug.apk");
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Views\"]").click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Layouts\"));");

	}

}
