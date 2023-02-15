package com.java;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StuInfo {
	
	private Student student;
	
	public void getStuInfo() {
		if(student !=null) {
			System.out.println("이름 : "+student.getName());
			System.out.println("나이 : "+student.getAge());
			System.out.println("학년 : "+student.getGrade());
			System.out.println("반 : "+student.getClassNum());
			System.out.println("=============================");
		}
	}
	

}
