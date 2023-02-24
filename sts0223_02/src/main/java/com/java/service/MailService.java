package com.java.service;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
	JavaMailSender mailSender;
	
	//비밀번호 생성
	public String getCreateKey() {
		String pwCode="";
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        int idx=0;
        for(int i=0;i<10;i++) {
        	idx = (int)(Math.random()*charSet.length); //0-35
        	pwCode += charSet[idx];
        }
		return pwCode;
	}//비밀번호
	
	//이메일 발송 - text형태 발송
	@Async
	public String mailSend(String userEmail,String userName) {
		SimpleMailMessage message = new SimpleMailMessage();
		String pwCode = getCreateKey(); //임시비밀번호생성
		System.out.println("이메일인증 비밀번호 : "+pwCode);
		
		//메일발송 정보
		String fromEmail="onulee@naver.com";
		String subject = userName+"님의 회원가입 이메일인증 임시번호 안내";
		String sendTxt ="안녕하세요. 회원가입 이메일인증 임시번호 안내관련 이메일입니다. \n"+
		                "["+userName+"]님 임시인증 비밀번호 : "+pwCode+" 입니다.\n";
		
		message.setTo(userEmail);    //발송할 대상 이메일주소
		message.setFrom(fromEmail);  //보내는 사람의 이메일주소
		message.setSubject(subject); //이메일발송 제목
		message.setText(sendTxt);    //이메일내용
		mailSender.send(message);    //이메일 발송
		
		//출력
		System.out.println("이메일 발송 완료");
		
		return pwCode;
		
	}//이메일발송
	
	//이메일 발송 - html 발송
	@Async
	public String mailSend2(String userEmail,String userName) {
		
		MimeMessage message = mailSender.createMimeMessage();
		
		String pwCode = getCreateKey(); //임시비밀번호생성
		System.out.println("이메일인증 비밀번호 : "+pwCode);
		
		//메일발송 정보
		String fromEmail="onulee@naver.com";
		String subject = userName+"님의 회원가입 이메일인증 임시번호 안내";
		String htmlTxt = "<html><body><img src='https://ssl.pstatic.net/melona/libs/1425/1425502/35324474d6ca6b907f1d_20230215145125129.jpg'><br>"
				+ "<h3>안녕하세요. 회원가입 이메일인증 임시번호 안내관련 이메일입니다.<br>"+
				"["+userName+"]님 임시인증 비밀번호 :<span style='color:red; font-weight:bold'> "+pwCode+"</span> 입니다.</h3></body></html>";
		
		try {
			message.setSubject(subject); //이메일발송 제목
			message.setFrom(new InternetAddress(fromEmail));  //보내는 사람의 이메일주소
			message.setText(htmlTxt,"utf-8","html");    //이메일내용
			message.addRecipient(RecipientType.TO, new InternetAddress(userEmail)); //발송할 대상 이메일주소
			mailSender.send(message);    //이메일 발송
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		//출력
		System.out.println("이메일 발송 완료");
		
		return pwCode;
		
	}//이메일발송
	
}
