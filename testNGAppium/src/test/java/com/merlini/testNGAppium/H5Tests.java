package com.merlini.testNGAppium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

public class H5Tests {
  private  WebDriver  driver;
  /**
   * 演示H5在chrome上执行
   */
  @BeforeMethod
  public void setUp(){
	  System.setProperty("webdriver.chrome.driver","D:\\Personal\\Driver\\chromedriver.exe");
      //DesiredCapabilities capabilities = DesiredCapabilities.chrome();    
	  ChromeDriverService chromeDirverService = ChromeDriverService.createDefaultService();
      ChromeOptions chromeOptions = new ChromeOptions();
	  chromeOptions.addArguments("start-maximized","--user-agent=Mozilla/5.0 (Linux; Android 4.1.2; Nexus 7 Build/JZ054K) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Safari/535.19","--screen=640,1136");
	  //chromeOptions.addArguments("start-maximized");
	  driver = new ChromeDriver(chromeDirverService,chromeOptions);
	  //driver = new ChromeDriver(chromeDirverService,chromeOptions);
  }
  @Test
  public void f() throws InterruptedException {
	  driver.navigate().to("http://www.ctrip.com");
	  Thread.sleep(1000000);
  }
}
