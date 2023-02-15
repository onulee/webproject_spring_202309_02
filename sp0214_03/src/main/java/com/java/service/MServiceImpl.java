package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberDao;

@Service
public class MServiceImpl implements MService {

	@Autowired
	MemberDao memberDao;
	
	public String memberSelectAll() {
		System.out.println("service에서 프로그램 구현합니다.");
		
		String id = memberDao.selectAll();
		return id;
	}

}
