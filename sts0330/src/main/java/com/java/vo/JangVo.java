package com.java.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JangVo {
	
	private int id;
	private Timestamp startDate;
	private Timestamp endDate;

}
