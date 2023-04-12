package com.java.service;

import java.util.function.Supplier;

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


	@Override  //1명 회원 검색
	public MemberVo findById(String id) {
		MemberVo memberVo = memberRepository.findById(id).orElseThrow(
				()->{  //람다식 예외처리
					return new IllegalArgumentException("해당 회원이 없습니다.");
				}
		);
		return memberVo;
	}


	@Override //로그인 
	public MemberVo findByIdAndPw(String id, String pw) {
		MemberVo memberVo = memberRepository.findByIdAndPw(id,pw);
		
		return memberVo;
	}

}
