package com.merlini.app.youth.page;

import io.appium.java_client.AppiumDriver;

import com.merlini.app.page.PageBase;

public class HotelSearchPage extends PageBase {
	public HotelSearchPage(AppiumDriver driver){
		this.driver=driver;
	}
	/**
	 * ���"�ҵ�λ��"
	 */
	public void clickMyPosition()
	{
		//
		findTextViewElementByText("�ҵ�λ��").click();
	}
	public void clickSearchButton(){
		findButtonElementByText("��ѯ").click();
	}

}
