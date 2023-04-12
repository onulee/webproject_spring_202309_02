package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.service.MemberService;
import com.java.vo.MemberVo;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(MemberVo memberVo,Model model) {
		String id = memberVo.getId();
		String pw = memberVo.getPw();
		MemberVo mVo = memberService.findByIdAndPw(id,pw);
		
		return "redirect:/";
	}
	
	@GetMapping("/join02")
	public String join02() {
		return "join02_info_input";
	}
	
	@PostMapping("/join03_success")
	public String join03_success(MemberVo memberVo) {
		System.out.println("id : "+memberVo.getId());
		memberService.memberSave(memberVo);
		return "join03_success";
	}

}
