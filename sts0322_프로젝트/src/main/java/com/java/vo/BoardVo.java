package com.java.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder  //부분생성자
@AllArgsConstructor  //전체생성자
@NoArgsConstructor  //기본생성자
@Data  //getter,setter
public class BoardVo {

	int bno;
	String id;
	String btitle;
	String bcontent;
	Timestamp bdate;
	int bstep;
	int bhit;
	int bgroup;
	int bindent;
	String bfile;
	int topchk;
	
	
}
