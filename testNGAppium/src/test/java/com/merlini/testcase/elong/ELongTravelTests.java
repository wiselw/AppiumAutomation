package com.merlini.testcase.elong;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.merlini.app.common.AppiumDriverExpectedCondition;
import com.merlini.app.common.AppiumDriverWait;
import com.merlini.common.BaseCase;

public class ELongTravelTests extends BaseCase{
	private AppiumDriver driver;
	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		Reporter.log("setUp");
		File appPath =new File("D://adt-bundle-windows-x86");
		File app = new File(appPath, "ElongTravel_6.4.2_melong.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName","V849DYLNVSNVZSIZ");//bbc4e9a//1844d244//V849DYLNVSNVZSIZ
		capabilities.setCapability("platformVersion", "4.2.2");
		//capabilities.setCapability("automationName","Selendroid");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("app-package", "com.dp.android.elong");
		capabilities.setCapability("app-activity", "com.elong.activity.others.AppGuidActivity");
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 }

	@AfterMethod
	public void afterMethod() {
		  driver.quit();
	}
  @Test
  public void f() {
	  AppiumDriverWait wait=new AppiumDriverWait(driver);
	  WebElement ele=
		wait.until( new AppiumDriverExpectedCondition<WebElement>(){
			public WebElement apply(AppiumDriver driver){
				return driver.findElementByXPath("//android.widget.TextView[@text,'酒店']");
			}
		});
	  ele.click();
  }
}
