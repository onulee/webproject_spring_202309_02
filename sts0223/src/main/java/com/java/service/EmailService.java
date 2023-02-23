package com.java.service;

import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	// 임시비밀번호 생성
	public String getCreateKey() {
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		String pwCode = "";
		int idx = 0;
		for (int i = 0; i < 10; i++) {
			idx = (int) (charSet.length * Math.random()); // 36*0.99=35.64 0-35
			pwCode += charSet[idx];
		}
		return pwCode;
	}

	// 이메일 발송
	@Async //비동기 처리
	public void mailSend(String userEmail, String userName) {
		SimpleMailMessage message = new SimpleMailMessage();
		// 임시비밀번호 생성
		String pwCode = getCreateKey();
		System.out.println("비밀번호 생성 : " + pwCode);

		message.setTo(userEmail);
		message.setFrom("onulee74@gmail.com");
		message.setSubject(userName + "님의 회원가입 이메일인증 임시비밀번호 안내");
		message.setText("안녕하세요. 회원가입 이메일인증 임시비밀번호 안내 관련 이메일 입니다.\n" + "[" + userName + "]" + "님의 임시 비밀번호는 " + pwCode
				+ " 입니다.\n");
		mailSender.send(message);
		System.out.println("이멜 전송 완료!");
	}
	
	// 이메일 발송
	@Async //비동기 처리
	public void mailSend2(String userEmail, String userName) {
		MimeMessage message = mailSender.createMimeMessage();
		// 임시비밀번호 생성
		String pwCode = getCreateKey();
		System.out.println("비밀번호 생성 : " + pwCode);
		
		try {
			message.setSubject("[안내]"+ userName +"님 회원가입 이메일인증 임시비밀번호 안내", "UTF-8");
			String htmlContent = "안녕하세요. 회원가입 이메일인증 임시비밀번호 "
					+ "안내 관련 이메일 입니다.\n" + "[" + userName + "]" + 
					"님의 임시 비밀번호는 <span style='color:red'> " + pwCode
					+ " </span> 입니다.\n";
			message.setText(htmlContent, "UTF-8", "html");
			message.setFrom(new InternetAddress("onulee74@gmail.com"));
			message.addRecipient(RecipientType.TO, new InternetAddress(userEmail));
			mailSender.send(message);
			System.out.println("이멜 전송 완료!");
		} catch (MessagingException e) {
			e.printStackTrace();
			return;
		} // try - catch
	}
	
	// 이메일 발송
	@Async //비동기 처리
	public void mailSend3(String userEmail, String userName) {
		MimeMessage message = mailSender.createMimeMessage();
		// 임시비밀번호 생성
		String pwCode = getCreateKey();
		System.out.println("비밀번호 생성 : " + pwCode);
		
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setSubject("[안내]"+ userName +"님 회원가입 이메일인증 임시비밀번호 안내");
			String htmlContent = "안녕하세요. 회원가입 이메일인증 임시비밀번호 "
					+ "안내 관련 이메일 입니다.\n" + "[" + userName + "]" + 
					"님의 임시 비밀번호는 <span style='color:red'> " + pwCode
					+ " </span> 입니다.\n";
			messageHelper.setText(htmlContent, true);
			messageHelper.setFrom("onulee74@gmail.com", "운이");
			messageHelper.setTo(new InternetAddress(userEmail,userName , "UTF-8"));
			DataSource dataSource = new FileDataSource("c:\\list.txt");
			messageHelper.addAttachment(MimeUtility.encodeText("list.txt", "UTF-8", "B"), dataSource);
			
			mailSender.send(message);
			
			System.out.println("이멜 전송 완료!");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} // try - catch
	}

}//class
