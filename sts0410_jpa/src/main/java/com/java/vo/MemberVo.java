package com.java.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity  //jpa생성
public class MemberVo {
	
	@Id  //primary key
	@Column(nullable = false,length=30) //not null,길이30 varchar2(30) not null
	private String id;
	
	@Column(nullable = false,length=100)
	private String pw;
	@Column(length = 100)
	private String name;
	@Column(length=20)
	private String phone;
	@ColumnDefault("'male'")  //문자열은 '', 숫자 ""
	private String gender;  //male,female
	@Column(length=100)
	private String hobby;
	
}
