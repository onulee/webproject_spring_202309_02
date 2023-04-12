package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

//예외처리
//@RestController  //데이터를 리턴
@ControllerAdvice   //Controller중 제일먼저 실행
@Controller      //페이지를 리턴
public class GlobalExceptionHandler {
	
	public String handleArgumentException(IllegalAccessException e,Model model) {
		model.addAttribute("message",e.getMessage());
		return "error";
	}
	
	public String handleArgumentException(NullPointerException e) {
		return "error3";
	}
	
	public String handleArgumentException(ArithmeticException e) {
		return "error2";
	}
	
	
	
	

}
