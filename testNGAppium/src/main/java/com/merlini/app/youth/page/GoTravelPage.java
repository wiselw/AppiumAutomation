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
			driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"�Ժ���˵\")").click();
		}
		catch(Exception e)
		{
			System.out.println("û�������汾��ʾ");
		}
//		AppiumDriverWait wait=new AppiumDriverWait(driver);
//        WebElement version=wait.until(visibilityOfElementLocated("new UiSelector().className(\"android.widget.TextView\").text(\"�Ժ���˵\")"));
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
//		case "��㳡":
//			WebElement square=WaitForElement(By.linkText(tabName));
//			square.click();
//			break;
//		case "ȥ����":
//			WebElement travel=WaitForElement(By.linkText(tabName));
//			travel.click();
//			break;
//		case "��":
//			WebElement login=WaitForElement(By.linkText(tabName));
//			login.click();
//			break;
//		default:
//			throw new NoSuchElementException("�ı�:"+tabName+"δ����");
//		}
	}
	public void nextToHotel()
	{
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"ס��\")").click();
		WebElement searchPageTitleEle=null;
		try{
			searchPageTitleEle=driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"����/����Ƶ�\")");	
		}catch(Exception e)
		{
			
		}
		Assert.assertNotNull(searchPageTitleEle);
	}

}
