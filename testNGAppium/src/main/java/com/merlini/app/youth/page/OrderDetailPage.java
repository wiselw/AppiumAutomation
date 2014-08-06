package com.merlini.app.youth.page;

import junit.framework.Assert;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

import com.merlini.app.common.AppHelper;
import com.merlini.app.common.AppiumDriverWait;
import com.merlini.app.page.PageBase;

public class OrderDetailPage extends PageBase {
	public OrderDetailPage(AppiumDriver driver){
		this.driver=driver;
	}
	public void checkOrderPage(){
		//
		String titlelocator="new UiSelector().className(\"android.widget.TextView\").text(\"订单填写\")";
		Assert.assertTrue(AppHelper.checkElementDisplay(driver,MobileBy.AndroidUIAutomator(titlelocator)));
		WebElement title=driver.findElement(MobileBy.AndroidUIAutomator(titlelocator));
		if (title!=null){
			System.out.println(title.getText());
		}
	}
    public void setGests(){
    	WebElement GestTextView=findElementByText("android.widget.TextView","入住人");
    	GestTextView.click();
    	
    };
}
