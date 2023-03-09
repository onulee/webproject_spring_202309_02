package com.java.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class NumBoardVo2 {
	
	private int seqno;
	private int num;
	private String id,pw;
	
	@Builder
	public NumBoardVo2(int seqno, int num, String id, String pw) {
		this.seqno = seqno;
		this.num = num;
		this.id = id;
		this.pw = pw;
	}
	
	public NumBoardVo2(int num, String id, String pw) {
		this.num = num;
		this.id = id;
		this.pw = pw;
	}
	
	

	
	
	

}
