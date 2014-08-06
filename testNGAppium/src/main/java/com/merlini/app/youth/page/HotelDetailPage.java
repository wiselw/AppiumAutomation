package com.merlini.app.youth.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import com.merlini.app.common.AppHelper;
import com.merlini.app.common.AppiumDriverWait;
import com.merlini.app.page.PageBase;

public class HotelDetailPage extends PageBase {
	public HotelDetailPage(AppiumDriver driver ){
		this.driver=driver;
	}
	public void selectRoom(int index){
		MobileElement room= new MobileElement((RemoteWebElement)findElementsByDescription("RelativeLayout","hotel_detail_room_item").get(index),driver);
		//WebElement room= (RemoteWebElement)findElementsByDescription("RelativeLayout","hotel_detail_room_item").get(index);
		//List<WebElement> priceElement=room.findElements(By.tagName("android.widget.TextView"));//room.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").instance(3)");
		//String price=priceElement.getAttribute("text");
		//System.out.println(price);
		//System.out.println(room.getId());
		//WebElement tmp=driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").fromParent(new UiSelector().className(\"android.widget.RelativeLayout\").description(\"hotel_detail_room_item\").instance(0))");
		
		WebElement priceElement=room.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").textContains(\"￥\")");
		String price=priceElement.getAttribute("text");
		System.out.println("price:"+price);
		WebElement reserveButton=room.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").text(\"预订\")");
		//MobileElement mobiletmp=new MobileElement((RemoteWebElement) tmp1,driver);
		//WebElement ele=driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").textContains(\"379\")");
		//System.out.println("mobiletmp.getText()"+mobiletmp.getText());
		//System.out.println(priceElement.size());
		reserveButton.click();
		//MobileElement popview=new MobileElement((RemoteWebElement)findElementsByIndex("RelativeLayout","hotel_detail_room_item").get(index),driver);
		
	}
	/**
	 * 校验是否进入登录界面
	 * @return
	 */
	public boolean checkLogin(){
		return AppHelper.checkElementDisplay(driver, MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"登录/预订\")"));
		
	}

}
