package com.merlini.testNGAppium;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Config {
	private static final String BUNDLE_NAME = "conf"; 

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
            .getBundle(BUNDLE_NAME);

    private Config() {
    }

    public static String getConfBykey(String key) {
    	
    	//System.out.println(Locale.getDefault());
    	//System.out.println(RESOURCE_BUNDLE.keySet().size());
        String value = RESOURCE_BUNDLE.getString(key);
            try {
                String keyValue = new String(value.getBytes("UTF-8"), "UTF-8");
                return keyValue;
            } catch (UnsupportedEncodingException e) {
                return '!' + key + '!';
            } 
    }

}
