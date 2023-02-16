package com.java.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member {
	
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String gender;
	private String[] hobbys;

}
