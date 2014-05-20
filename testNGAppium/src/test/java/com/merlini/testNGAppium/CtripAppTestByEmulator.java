package com.merlini.testNGAppium;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class CtripAppTestByEmulator {
	private AppiumDriver driver;
    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {
	    File appPath =new File("D://adt-bundle-windows-x86");
		File app = new File(appPath, "ctrip_9289.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName","emulator-5554");
		capabilities.setCapability("platformVersion", "4.3");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("app-package", "ctrip.android.view");
		capabilities.setCapability("app-activity", "ctrip.android.view.home.CtripSplashActivity");
		driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }
    @Test
    public void f() {
        WebDriverWait wait=new WebDriverWait(driver,50,500);
		WebElement hotel=wait.until( new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver driver){
				return driver.findElement(By.name("酒店"));
			}
		});
		//driver.findElementByAndroidUIAutomator("以后再说");
		hotel.click();
		driver.findElementByName("酒店").click();
		driver.findElementByAccessibilityId("hotelcheckincity").click();
		driver.findElementsByAccessibilityId("city_list_item").get(9).click();
    }
    @AfterMethod
    public void afterMethod() {
    	driver.quit();
    }

}
