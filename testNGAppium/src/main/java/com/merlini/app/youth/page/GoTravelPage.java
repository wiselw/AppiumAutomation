package com.merlini.app.youth.page;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;

import com.merlini.app.common.AppiumDriverWait;
import com.merlini.app.common.AppiumExpectedCondition;
import com.merlini.app.page.PageBase;


public class GoTravelPage extends PageBase {
	public GoTravelPage(AppiumDriver driver){
		this.driver=driver;
	}
	public void checkVersion(){
		
		//
		try
		{
			driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"以后再说\")").click();
		}
		catch(Exception e)
		{
			System.out.println("没有升级版本提示");
		}
//		AppiumDriverWait wait=new AppiumDriverWait(driver);
//        WebElement version=wait.until(visibilityOfElementLocated("new UiSelector().className(\"android.widget.TextView\").text(\"以后再说\")"));
//        if (version!=null){
//        	version.click();
//        }
	}
	public void navigateTo(final String tabName){
		checkVersion();
		AppiumDriverWait wait=new AppiumDriverWait(driver);
		WebElement ele= wait.until( new AppiumExpectedCondition<WebElement>(){
			public WebElement apply(AppiumDriver driver){
				return driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\""+tabName+"\")");
			}
		});
		ele.click();
//		switch(tabName){
//		case "逛广场":
//			WebElement square=WaitForElement(By.linkText(tabName));
//			square.click();
//			break;
//		case "去旅行":
//			WebElement travel=WaitForElement(By.linkText(tabName));
//			travel.click();
//			break;
//		case "我":
//			WebElement login=WaitForElement(By.linkText(tabName));
//			login.click();
//			break;
//		default:
//			throw new NoSuchElementException("文本:"+tabName+"未出现");
//		}
	}
	public void nextToHotel()
	{
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"住宿\")").click();
		WebElement searchPageTitleEle=null;
		try{
			searchPageTitleEle=driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"国内/海外酒店\")");	
		}catch(Exception e)
		{
			
		}
		Assert.assertNotNull(searchPageTitleEle);
	}

}
