package com.merlini.app.youth.page;

import io.appium.java_client.AppiumDriver;

import com.merlini.app.page.PageBase;

public class FilterPage extends PageBase {
	public FilterPage(AppiumDriver driver){
		this.driver=driver;
	}
    public void setPayMethod(String payMethod){
    	findTextViewElementByText("֧����ʽ").click();
    	findElementByText("CheckedTextView","���긶��(�Ƶ�ǰ̨����)").click();
    	findButtonElementByText("ȷ��").click();
    }
}
