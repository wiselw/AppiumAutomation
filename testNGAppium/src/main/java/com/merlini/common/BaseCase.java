package com.merlini.common;

import io.appium.java_client.AppiumDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.merlini.app.common.AppHelper;

public class BaseCase {
	public final static int ELEMENT_FIND_TIMEOUT = Integer.parseInt(Config.getConfBykey("element.find.timeout"));
	public final static int DRIVER_RESPONSE_TIMEOUT = Integer.parseInt(Config.getConfBykey("driver.response.timeout"));
	public final static int PAGE_LOAD_TIMEOUT = Integer.parseInt(Config.getConfBykey("page.load.timeout"));
	public final static int JAVASCRIPT_EXCUTE_TIMEOUT = Integer.parseInt(Config.getConfBykey("javascript.excute.timeout"));
	/**
	 * AppiumDriverWait �ȴ�ʱ��
	 */
	public final static int WAIT_TIMEOUT_INSECONDS = Integer.parseInt(Config.getConfBykey("wait.TimeOutInSeconds"));
	/**
	 * AppiumDriverWait ��ѯʱ��
	 */
	public final static int WAIT_SLEEPINMILLS=Integer.parseInt(Config.getConfBykey("wait.sleepInMillis"));

    public final static String STR_NAV_JS=" return navigator.userAgent.toLowerCase() ; ";
    public static String getDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    public AppiumDriver driver=null;
    @AfterMethod
    public void afterMethod(ITestResult result) {
  	  if(!result.isSuccess()){
  		  //
  		//�����ͼ
  		AppHelper.takeScreenShoot(driver); 
  	  }
    }

}
