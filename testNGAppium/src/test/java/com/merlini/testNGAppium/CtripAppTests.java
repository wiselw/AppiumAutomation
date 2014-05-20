package com.merlini.testNGAppium;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class CtripAppTests {
	private AppiumDriver driver;
	@BeforeMethod
	public void setUp() throws MalformedURLException{
		Reporter.log("setUp");
		File appPath =new File("D://adt-bundle-windows-x86");
	    File app = new File(appPath, "ctrip_9289.apk");
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	    capabilities.setCapability("platformName", "Android");
	    capabilities.setCapability("deviceName","V849DYLNVSNVZSIZ");//bbc4e9a//1844d244//V849DYLNVSNVZSIZ
	    capabilities.setCapability("platformVersion", "4.3");
	    capabilities.setCapability("app", app.getAbsolutePath());
	    capabilities.setCapability("app-package", "ctrip.android.view");
	    capabilities.setCapability("app-activity", "ctrip.android.view.home.CtripSplashActivity");
	    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(enabled=false)
	public void testHotel() {
		WebDriverWait wait=new WebDriverWait(driver,20,500);
		Reporter.log("������Ƶꡯ");
		WebElement hotel=wait.until( new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver driver){
				return driver.findElement(By.name("�Ƶ�"));
			}
		});
		hotel.click();
		driver.findElementByName("�Ƶ�").click();
		driver.findElementByAccessibilityId("hotelcheckincity").click();
		driver.findElementsByAccessibilityId("city_list_item").get(9).click();
	}
	@Test
	public void testHomePage() {
		WebDriverWait wait=new WebDriverWait(driver,20,500);
		Reporter.log("�������Ʊ��");
		WebElement banner =wait.until( new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver driver){
				return driver.findElement(By.name("��Ʊ"));
			}
		});
		//WebElement conten_grid_ayout=driver.findElementByAccessibilityId("conten_grid_ayout");
		WebElement conten_grid_ayout =
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"��Ʊ\")");
		conten_grid_ayout.click();
		//driver.findElementByAccessibilityId("Я������").click();
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='f1_btn_switch_city']")).click();
		WebElement tab_flight_inquire =driver.findElementById("tab_flight_inquire");
		org.testng.Assert.assertEquals(tab_flight_inquire.getText(), "��Ʊ��ѯ");
		
	}
	@Test(enabled=false)
	public void testFlight() {
		WebDriverWait wait=new WebDriverWait(driver,20,500);
		Reporter.log("�������Ʊ��");
		WebElement flight=wait.until( new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver driver){
				return driver.findElement(By.name("��Ʊ"));
			}
		});
		flight.click();
	}
	@AfterMethod
	public void tearDown(){
		Reporter.log("tearDown");
		driver.quit();
	}
}
