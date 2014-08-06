package com.merlini.app.youth.page;

import io.appium.java_client.AppiumDriver;

import com.merlini.app.page.PageBase;

public class FilterPage extends PageBase {
	public FilterPage(AppiumDriver driver){
		this.driver=driver;
	}
    public void setPayMethod(String payMethod){
    	findTextViewElementByText("支付方式").click();
    	findElementByText("CheckedTextView","到店付款(酒店前台付款)").click();
    	findButtonElementByText("确定").click();
    }
}
