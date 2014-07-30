package com.merlini.app.page;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import com.iassert.IAssert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class HotelHomePage extends PageBase {
	public HotelHomePage(AppiumDriver driver){
		//
		this.driver=driver;
	}
	//private WebElement citySetButton=driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"我附近的酒店\")");

	public void setCity(String city){
		//
//		String str="";
//		try {
//			 str = new String(city.getBytes(),"UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").index(0)").click();
		WebElement searchEdit=
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\""+city+"\")");	
	}
	public void checkCity(String city){
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").index(0)").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").index(0)").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").index(0)").sendKeys(city);
		List<WebElement> lisElement= driver.findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\""+city+"\")");
		IAssert.assertTrue(lisElement.size()>0,city);
		System.out.println(lisElement.size());
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").index(0)").sendKeys("北京");
		
		List<WebElement> lisElement1= driver.findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\""+city+"\")");
		System.out.println(lisElement1.size()>0);
		IAssert.assertTrue(lisElement1.size()>0,"北京");
		//driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").text(\"中文/拼音/首字母/英文\")").click();
		//driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\""+city+"\")").click();
	}
	public void setDate(){
		//
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").childSelector(new UiSelector().className(\"android.widget.TextView\").text(\"入住\")).index(0)").click();
        MobileElement ele=new MobileElement((RemoteWebElement) driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.view.View\").index(5)"),driver);
        Point pc=ele.getCenter();
        Point p= ele.getLocation();
        System.out.println("x:"+p.getX()+",y:"+p.getY());
        TouchAction ta=new TouchAction(driver);
        ta.tap(pc.x,pc.y).perform();
        File Screenshot= driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(Screenshot, new File("APP.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
    public void checkPP(){
    	//
//    	driver.findElement(By.name("关键字/位置/品牌/酒店名")).click();
//    	driver.findElement(By.name("品牌")).click();
    	List<WebElement> list=getElementsByClassAndIndex("android.widget.TextView",0);
    	list.get(3).click();
    	WebElement searchEdit =getElementByIndex("android.widget.EditText",0);
    	searchEdit.click();
    	WebElement searchEdit1 =getElementByIndex("android.widget.EditText",0);
    	searchEdit1.sendKeys("上海");
    	//clear(searchEdit1);
//    	System.out.println(list.size());
//    	for(WebElement ele : list){
//    		System.out.println(ele.getAttribute("text"));
//    	}
    	//driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.RelativeLayout[0]/android.widget.TextView")).click();
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
