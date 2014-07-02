package com.merlini.app.page;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

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
		List<WebElement> listTextView=getElementsByClassAndIndex("android.widget.LinearLayout",0);
		System.out.println(listTextView.size());
		for(WebElement element : listTextView){
			System.out.println(element.getAttribute("text"));
//			if (element.getText().contains("年")){
//				element.click();
//				break;
//			}
		}
		
	}

}
