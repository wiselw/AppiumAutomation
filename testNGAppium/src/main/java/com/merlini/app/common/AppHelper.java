package com.merlini.app.common;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

import com.merlini.common.Config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class AppHelper {
	//默认轮询时间(毫秒)
	public final static long DEFAULT_POLLINGEVERY_TIMEMILLS = Integer.parseInt(Config.getConfBykey("wait.sleepInMillis"));
	public final static long DEFAULT_TIMEOUT_INSECONDS = Integer.parseInt(Config.getConfBykey("wait.TimeOutInSeconds"));
	public static AppiumDriver InitializeDriver(String apkPath,String appPackage,String appActivity){
		//
		AppiumDriver driver=null;
//		File appPath =new File("D://adt-bundle-windows-x86");
//		File app = new File(appPath, "Ctrip_Wireless_View_sit15.apk");
		File app =new File(apkPath);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", Config.getConfBykey("platformName"));
		capabilities.setCapability("deviceName",Config.getConfBykey("deviceName"));//bbc4e9a//1844d244//V849DYLNVSNVZSIZ
		capabilities.setCapability("platformVersion", Config.getConfBykey("platformVersion"));
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("app-package", appPackage);
		capabilities.setCapability("app-activity", appActivity);
		try {
			driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}
	public static AppiumDriver InitializeDriver(String appPackage,String appActivity){
		//
		AppiumDriver driver=null;
//		File appPath =new File("D://adt-bundle-windows-x86");
//		File app = new File(appPath, "Ctrip_Wireless_View_sit15.apk");
		File app =new File(Config.getConfBykey("appPath"));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", Config.getConfBykey("platformName"));
		capabilities.setCapability("deviceName",Config.getConfBykey("deviceName"));//bbc4e9a//1844d244//V849DYLNVSNVZSIZ
		capabilities.setCapability("platformVersion", Config.getConfBykey("platformVersion"));
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("app-package", appPackage);
		capabilities.setCapability("app-activity", appActivity);
		try {
			driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}
	/**
	 * 截图方法（图片存放位置在配置文件中配置，配置项名称picPath，图片格式 jpg）
	 * @param driver
	 */
	public static void takeScreenShoot(AppiumDriver driver){
		
		File Screenshot= driver.getScreenshotAs(OutputType.FILE);
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			Calendar cal = Calendar.getInstance();
			String timeStamp=dateFormat.format(cal.getTime());
			FileUtils.copyFile(Screenshot, new File(Config.getConfBykey("picPath")+timeStamp+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 校验元素是否存在且显示（轮询时间默认）
	 * @param driver  
	 * @param locator
	 * @param timeOutInSeconds 超时时间
	 * @return
	 */
	public static boolean checkElementDisplay(AppiumDriver driver,final By locator,long timeOutInSeconds){
		WebElement webElement=null;
		try{
			WebDriverWait wait=new WebDriverWait(driver,timeOutInSeconds,DEFAULT_POLLINGEVERY_TIMEMILLS);
			webElement =wait.until(new ExpectedCondition<WebElement>(){
				public WebElement apply(WebDriver driver){
					return driver.findElement(locator);
				}
			});
		}
		catch(Exception e){
			webElement=null;
		}
		if (webElement==null){
			return false;
		}
		else{
	    return webElement.isDisplayed() ? true : false;
		}
	}
	/**
	 * 校验元素是否存在且显示（轮询时间和超时时间均为默认）
	 * @param driver  
	 * @param locator
	 * @return
	 */
	public static boolean checkElementDisplay(AppiumDriver driver,final By locator ){
		WebElement webElement=null;
		try{
			WebDriverWait wait=new WebDriverWait(driver,DEFAULT_TIMEOUT_INSECONDS,DEFAULT_POLLINGEVERY_TIMEMILLS);
			webElement =wait.until(new ExpectedCondition<WebElement>(){
				public WebElement apply(WebDriver driver){
					return driver.findElement(locator);
				}
			});
		}
		catch(Exception e){
			webElement=null;
		}
		if (webElement==null){
			return false;
		}
		else{
	    return webElement.isDisplayed() ? true : false;
		}
	}
	
	/**
	 * 根据控件description抓取批量元素
	 * @param elementType
	 * @param desc
	 * @return
	 */
	public static List<WebElement> findElementsByDescription(AppiumDriver driver,final String elementType,final String desc){
		AppiumDriverWait wait=new AppiumDriverWait(driver);
		List<WebElement> ele= wait.until( new AppiumExpectedCondition<List<WebElement>>(){
			public List<WebElement> apply(AppiumDriver driver){
				return driver.findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget."+elementType+"\").description(\""+desc+"\")");
			}
		});
		return ele;
	}

}
