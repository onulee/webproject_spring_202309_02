package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.java.service.MService;

@Controller
public class FController {
	
	@Autowired
	MService mservice;
	
	public void serviceSelectAll() {
		
		System.out.println("서비스에서 데이터값을 전달합니다.");
		String id = mservice.memberSelectAll();
		System.out.println("service 메소드 호출 후 데이터값 전달 : "+id);
	}

}
