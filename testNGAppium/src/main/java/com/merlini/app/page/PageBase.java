package com.merlini.app.page;

import io.appium.java_client.AppiumDriver;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.merlini.app.common.AppiumExpectedCondition;
import com.merlini.app.common.AppiumDriverWait;

public class PageBase {
	private final static Logger log = Logger.getLogger(ExpectedConditions.class.getName());
	public AppiumDriver driver;
	public WebElement WaitForElement(final By locator){
		AppiumDriverWait wait=new AppiumDriverWait(driver);
		return wait.until( new AppiumExpectedCondition<WebElement>(){
			public WebElement apply(AppiumDriver driver){
				return driver.findElement(locator);
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
	public WebElement getElementByIndex(String classname,int index){
		return driver.findElementByAndroidUIAutomator("new UiSelector().className("+classname+").index("+index+")");
	}
	public void clear(WebElement el){
		el.click(); //ѡ�������
		driver.sendKeyEvent(123);//������Ƶ����
		String txt = el.getText(); //��ȡ�ַ�������
		System.out.println(txt);
		for(int i=0;i<txt.length();i++){
		driver.sendKeyEvent(112);//һ������ɾ������������
		}
	}
	public WebElement findTextViewElementByText(String text){
		return driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\""+text+"\")");
	}
	public WebElement findElementByText(String elementType,String text){
		return driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget."+elementType+"\").text(\""+text+"\")");
	}
	public WebElement findButtonElementByText(String text){
		return driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").text(\""+text+"\")");
	}
	/**
	 * ���ݿؼ�descriptionץȡ����Ԫ��
	 * @param elementType
	 * @param desc
	 * @return
	 */
	public List<WebElement> findElementsByDescription(final String elementType,final String desc){
		AppiumDriverWait wait=new AppiumDriverWait(driver);
		List<WebElement> ele= wait.until( new AppiumExpectedCondition<List<WebElement>>(){
			public List<WebElement> apply(AppiumDriver driver){
				return driver.findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget."+elementType+"\").description(\""+desc+"\")");
			}
		});
		return ele;//driver.findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget."+elementType+"\").description(\""+desc+"\")"); 
	}
	public List<WebElement> findElementsByIndex(String elementType,int index){
		return driver.findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget."+elementType+"\").instant("+index+")"); 
	}
	private  WebElement findElement(String locator, AppiumDriver driver) {
	    try {
	      return driver.findElementByAndroidUIAutomator(locator);
	    } catch (NoSuchElementException e) {
	      //throw e;
	    	return null;
	    } catch (WebDriverException e) {
	      log.log(Level.WARNING,
	          String.format("WebDriverException thrown by findElement(%s)", locator), e);
	      throw e;
	    }
	  }
	private  WebElement elementIfVisible(WebElement element) {
		if (element==null){
			return null;
		}
		else{
	    return element.isDisplayed() ? element : null;
		}
	  }
	public  AppiumExpectedCondition<WebElement> visibilityOfElementLocated(
		      final String locator) {
		    return new AppiumExpectedCondition<WebElement>() {
		      @Override
		      public WebElement apply(AppiumDriver driver) {
		        try {
		          return elementIfVisible(findElement(locator, driver));
		        } catch (StaleElementReferenceException e) {
		          return null;
		        }
		      }
		      @Override
		      public String toString() {
		        return "visibility of element located by " + locator;
		      }

		    };
		  }
   
}
