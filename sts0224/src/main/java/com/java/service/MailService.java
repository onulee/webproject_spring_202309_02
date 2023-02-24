package com.java.service;

public interface MailService {
	
	public String getCreateKey();
	
	public String mailSend(String userEmail,String userName);
	
	public String mailSend2(String userEmail,String userName);

	public String mailSend3(String userEmail, String userName);

}
