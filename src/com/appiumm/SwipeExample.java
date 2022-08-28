package com.appiumm;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class SwipeExample extends BaseClass {
	
	public static void main(String[] args) throws MalformedURLException {
		
		appLaunch("D:\\\\My data\\\\Java\\\\AppiumClass\\\\APK\\\\ApiDemos-debug.apk");
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Views\"]").click();
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Date Widgets\"]").click();
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"2. Inline\"]").click();
		WebElement nine = driver.findElementByXPath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"9\"]");
		nine.click();
		WebElement fortyFive = driver.findElementByXPath("//*[@content-desc='25']");
		TouchAction a = new TouchAction(driver);
		a.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(nine))
				.withDuration(Duration.ofSeconds(1)))
				.moveTo(ElementOption.element(fortyFive)).release().perform();
		driver.navigate().back();
		driver.navigate().back();
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]").click();
		WebElement drag = driver.findElementsByClassName("android.view.View").get(0);
		WebElement drop = driver.findElementById("io.appium.android.apis:id/drag_dot_3");
		a.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(drag))
				.withDuration(Duration.ofSeconds(0)))
				.moveTo(ElementOption.element(drop)).release().perform();
		
		
	}

}
