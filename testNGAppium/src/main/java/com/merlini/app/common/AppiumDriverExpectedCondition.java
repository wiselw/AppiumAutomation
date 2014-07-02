package com.merlini.app.common;

import io.appium.java_client.AppiumDriver;

import com.google.common.base.Function;

public interface AppiumDriverExpectedCondition<T> extends Function<AppiumDriver,T>{

}
