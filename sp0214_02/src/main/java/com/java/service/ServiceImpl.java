package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.dao.MemberDao;

@Component
public class ServiceImpl implements Service {

	@Autowired
	MemberDao mdao;
	
	public String list() {
	
		String id = mdao.selectAll();
		return id;
	}

	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}

}
