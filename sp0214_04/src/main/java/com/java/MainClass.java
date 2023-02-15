package com.java;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:app_config.xml");
		
		StuInfo stuInfo = ctx.getBean("stuInfo",StuInfo.class);
		stuInfo.getStuInfo();
		
		Student student2 = ctx.getBean("student2",Student.class); 
		stuInfo.setStudent(student2);
		stuInfo.getStuInfo();
		
		
	}

}
