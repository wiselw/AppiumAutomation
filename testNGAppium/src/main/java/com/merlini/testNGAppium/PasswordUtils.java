package com.merlini.testNGAppium;

import java.util.List;

public class PasswordUtils {
	@CaseType(name="验证合法性",description="是否包含符合要求的字符串")
    public boolean validatePassword(String password){
    	return (password.matches("\\w*\\d\\w*"));
    }
	@CaseType(name="验证编码",description="编码")
    public String encryptPassword(String password){
    	return new StringBuilder(password).reverse().toString();
    }
	@CaseType(name="验证密码是否存在")
    public boolean checkForNewPasswod(List<String> prevPasswords,String password){
    	return !prevPasswords.contains(password);
    }

}
