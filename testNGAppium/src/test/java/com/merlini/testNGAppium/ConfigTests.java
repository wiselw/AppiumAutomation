package com.merlini.testNGAppium;

import org.testng.annotations.Test;

public class ConfigTests {
  @Test
  public void getConfBykeyTest() {
	  
	  org.testng.Assert.assertEquals(Config.getConfBykey("wait.TimeOutInSeconds"), "20");
  }
}
