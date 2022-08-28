package com.appiumm;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class EComExample extends BaseClass {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		appLaunch(".\\APK\\General-Store.apk");
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));");
		driver.findElement(By.xpath("//*[@text='India']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("HelloWorld");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		/*
		 * String toast =
		 * driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name"
		 * ); System.out.println(toast);
		 */
		/*
		 * driver.findElementByAndroidUIAutomator(
		 * "new UiScrollable(new UiSelector()).scrollIntoView(text(\"LeBron Soldier 12 \"));"
		 * );
		 */
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()"
				+ ".resourceId(\"com.androidsample.generalstore:id/rvProductList\"))"
				+ ".scrollIntoView(new UiSelector().textMatches(\"LeBron Soldier 12 \")" + ".instance(0))"));
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			System.out.println(text);

			if (text.equals("LeBron Soldier 12 ")) {

				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();

				break;
			} else {
				System.out.println("Nope");
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		WebElement checkBox = driver.findElement(By.className("android.widget.CheckBox"));

		TouchAction a = new TouchAction(driver);
		a.tap(TapOptions.tapOptions().withElement(ElementOption.element(checkBox))).perform();
		WebElement terms = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		a.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(terms))
				.withDuration(Duration.ofSeconds(2))).release().perform();
		driver.findElementByXPath("//*[@text='CLOSE']").click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(5000);
		Set<String> contextHandles = driver.getContextHandles();

		for (String string : contextHandles) {

			System.out.println(string);

		}
		Thread.sleep(3000);

		// appium --allow-insecure chromedriver_autodownload
		driver.context("WEBVIEW_com.androidsample.generalstore");

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Sree Ravindhar");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);

		driver.pressKey(new KeyEvent(AndroidKey.BACK));

	}

}
