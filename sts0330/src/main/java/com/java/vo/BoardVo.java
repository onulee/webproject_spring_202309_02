package com.java.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardVo {
	
	private int bno;
	private String id,btitle,bcontent;
	private Timestamp bdate;
	private int bstep,bhit,bgroup,bindent;
	private String bfile;
	private int topchk;

}
