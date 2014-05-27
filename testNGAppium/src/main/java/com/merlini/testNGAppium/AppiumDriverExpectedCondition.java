package com.merlini.testNGAppium;

import io.appium.java_client.AppiumDriver;

import com.google.common.base.Function;
/**
 *only belong to AppiumDriverWait
 * @author weiliang
 *
 * @param <T>
 */
public interface AppiumDriverExpectedCondition<T> extends Function<AppiumDriver,T>{

}
