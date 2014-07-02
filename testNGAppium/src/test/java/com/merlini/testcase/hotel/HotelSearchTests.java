package com.merlini.testcase.hotel;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.merlini.app.page.HomePage;
import com.merlini.app.page.HotelHomePage;
import com.merlini.app.page.Navi;
import com.merlini.common.BaseCase;

public class HotelSearchTests extends BaseCase{
	private AppiumDriver driver;
  @Test
  public void HotelSearchTest() {
	  //
	  HomePage homePage=new HomePage(driver);
	  homePage.SwitchTo(Navi.Hotel);
	  HotelHomePage hotelHomePage =new HotelHomePage(driver);
	  hotelHomePage.setCity("上海");
	  hotelHomePage.setDate();
  }
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	Reporter.log("setUp");
	File appPath =new File("D://adt-bundle-windows-x86");
	File app = new File(appPath, "CTRIP_WIRELESS_V5.7_SIT15_PRODUCT.apk");
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("deviceName","V849DYLNVSNVZSIZ");//bbc4e9a//1844d244//V849DYLNVSNVZSIZ
	capabilities.setCapability("platformVersion", "4.2.2");
	//capabilities.setCapability("automationName","Selendroid");
	capabilities.setCapability("app", app.getAbsolutePath());
	capabilities.setCapability("app-package", "ctrip.android.view");
	capabilities.setCapability("app-activity", "ctrip.android.view.home.CtripSplashActivity");
	driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
