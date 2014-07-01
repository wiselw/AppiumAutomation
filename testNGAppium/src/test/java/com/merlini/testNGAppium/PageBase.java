package com.merlini.testNGAppium;

import java.util.List;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageBase {
	public AppiumDriver driver;
	public WebElement WaitForElement(final By locator){
		AppiumDriverWait wait=new AppiumDriverWait(driver);
		return wait.until( new AppiumDriverExpectedCondition<WebElement>(){
			public WebElement apply(AppiumDriver driver){
				return driver.findElement(locator);//driver.findElement(By.name("�Ƶ�"));
			}
		});
	}
	public List<WebElement> getElementsByClassAndIndex(String classname,int index){
		List<WebElement> lis =null;
		lis = driver.findElementsByAndroidUIAutomator("new UiSelector().className("+classname+").index("+index+")");
		return lis;
	}
	public List<WebElement> getElementsByClassAndIndexAndClickable(String classname,int index){
		List<WebElement> lis =null;
		lis = driver.findElementsByAndroidUIAutomator("new UiSelector().className("+classname+").index("+index+").clickable(true)");
		return lis;
	}
	public WebElement getElementByIndex(int index){
		return driver.findElementByAndroidUIAutomator("new UiSelector().index("+index+")");
	}
	public void clear(WebElement el){
		el.click(); //选中输入框
		driver.sendKeyEvent(123);//将光标移到最后
		String txt = el.getText(); //获取字符串长度
		for(int i=0;i<txt.length();i++){
		driver.sendKeyEvent(67);//一个个的删除。。。。。
		}
	}

}
