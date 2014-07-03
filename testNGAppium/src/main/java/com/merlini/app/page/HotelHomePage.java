package com.merlini.app.page;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

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
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").index(0)").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\""+city+"\")").click();
		
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

}
