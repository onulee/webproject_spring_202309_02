package com.java.vo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberVo {
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String gender;
	private String hobbys;

}
