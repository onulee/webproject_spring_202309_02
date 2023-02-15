package com.java.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.controller.FController;

public class MainClass {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("classpath:app_config.xml");
		FController fController = ctx.getBean(FController.class);
		fController.serviceSelectAll();
	}

}
