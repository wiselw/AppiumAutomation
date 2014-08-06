package com.merlini.app.youth.page;

import io.appium.java_client.AppiumDriver;

import com.merlini.app.page.PageBase;

public class HotelSearchPage extends PageBase {
	public HotelSearchPage(AppiumDriver driver){
		this.driver=driver;
	}
	/**
	 * 点击"我的位置"
	 */
	public void clickMyPosition()
	{
		//
		findTextViewElementByText("我的位置").click();
	}
	public void clickSearchButton(){
		findButtonElementByText("查询").click();
	}

}
