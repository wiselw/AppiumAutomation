package com.merlini.testNGAppium;

import java.util.List;

public class PasswordUtils {
	@CaseType(name="��֤�Ϸ���",description="�Ƿ��������Ҫ����ַ���")
    public boolean validatePassword(String password){
    	return (password.matches("\\w*\\d\\w*"));
    }
	@CaseType(name="��֤����",description="����")
    public String encryptPassword(String password){
    	return new StringBuilder(password).reverse().toString();
    }
	@CaseType(name="��֤�����Ƿ����")
    public boolean checkForNewPasswod(List<String> prevPasswords,String password){
    	return !prevPasswords.contains(password);
    }

}
