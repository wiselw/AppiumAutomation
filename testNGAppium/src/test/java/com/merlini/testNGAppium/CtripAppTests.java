package com.merlini.testNGAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileCommand;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import com.merlini.testNGAppium.car.CarHomePage;

public class CtripAppTests extends Base {
	private AppiumDriver driver;
	@BeforeMethod
	public void setUp() throws MalformedURLException{
		Reporter.log("setUp");
		File appPath =new File("D://adt-bundle-windows-x86");
	    File app = new File(appPath, "CTRIP_WIRELESS_V5.7_SIT15_PRODUCT.apk");
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	    capabilities.setCapability("platformName", "Android");
	    capabilities.setCapability("deviceName","V849DYLNVSNVZSIZ");//bbc4e9a//1844d244//V849DYLNVSNVZSIZ
	    capabilities.setCapability("platformVersion", "4.2.2");
	    capabilities.setCapability("automationName","Selendroid");
	    capabilities.setCapability("app", app.getAbsolutePath());
	    capabilities.setCapability("app-package", "ctrip.android.view");
	    capabilities.setCapability("app-activity", "ctrip.android.view.home.CtripSplashActivity");
	    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(enabled=false)
	public void testHotel() throws InterruptedException {
		AppHomePage homePage=new AppHomePage(driver);
		//进入主页，切换到酒店
		homePage.SwitchTo(Navi.Hotel);
//		AppiumDriverWait wait=new AppiumDriverWait(driver);
//		Reporter.log("������Ƶꡯ");
//		WebElement hotel=wait.until( new AppiumDriverExpectedCondition<WebElement>(){
//			public WebElement apply(AppiumDriver driver){
//				return driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]"));//driver.findElement(By.name("�Ƶ�"));
//			}
//		});
		//hotel.click();
		Thread.sleep(10000);
		//driver.findElementByName("�Ƶ�").click();
		//driver.findElementByAccessibilityId("hotelcheckincity").click();
		//driver.findElementsByAccessibilityId("city_list_item").get(9).click();
	}
	@Test(description="测试切换机票出发城市-到达城市",enabled=false)
	public void testSwitchDepartCityAndArriveCity() throws IOException {
		AppiumDriverWait wait=new AppiumDriverWait(driver);
		WebElement conten_grid_ayout =wait.until( new AppiumDriverExpectedCondition<WebElement>(){
			public WebElement apply(AppiumDriver driver){
				return driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"��Ʊ\")");
			}
		});
		conten_grid_ayout.click();
		String olddepart_city= driver.
				findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").description(\"depart_city\")")
				.getText();
		String oldarrive_city= driver.
				findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").description(\"arrive_city\")")
				.getText();
		Reporter.log("切换前，出发城市"+olddepart_city);
		Reporter.log("切换前，到达城市"+oldarrive_city);
		File Screenshot= driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screenshot, new File("APP.jpg"));
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.ImageButton\").instance(2)").click();
		String newdepart_city= 
				driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").description(\"depart_city\")").getText();
		String newarrive_city= 
				driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").description(\"arrive_city\")").getText();
		Reporter.log("切换后，出发城市"+newdepart_city);
		Reporter.log("切换后，到达城市"+newarrive_city);
		org.testng.Assert.assertEquals(newdepart_city, olddepart_city);
		org.testng.Assert.assertEquals(newarrive_city, oldarrive_city);	
	}
	@Test
	public void testCar() throws InterruptedException {
		AppHomePage homePage=new AppHomePage(driver);
		homePage.SwitchTo(Navi.Car);
		CarHomePage carHomePage=new CarHomePage(driver);
		carHomePage.switchToWebview();
		carHomePage.switchToTaxi();
		Thread.sleep(10000);
	}
	@AfterMethod
	public void tearDown(){
		Reporter.log("tearDown");
		//driver.execute(MobileCommand.LOCK,ImmutableMap.<String, Object>of());
		driver.quit();
	}
}
