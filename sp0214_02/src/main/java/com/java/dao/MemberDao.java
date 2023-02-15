package com.java.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.vo.MemberVo;

@Component
public class MemberDao {
	
	@Autowired
	MemberVo mvo;
	
	
	public String selectAll() {
		String id="admin관리자";
		
		
		return id;
	}

}
