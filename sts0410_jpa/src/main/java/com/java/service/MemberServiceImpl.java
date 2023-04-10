package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.java.repository.MemberRepository;
import com.java.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;
	// MemberMapper memberMapper;
	
	
	@Override
	public void memberSave(MemberVo memberVo) {
		memberRepository.save(memberVo);
		// List<MemberVo> list = memberRepository.findAll();
		
	}

}
