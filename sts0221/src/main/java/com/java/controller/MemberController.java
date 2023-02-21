package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.vo.MemberVo;

@Controller
public class MemberController {
	
	@RequestMapping("member/memberWrite")
	public String memberWrite() {
		return "member/memberWrite";
	}
	
	@RequestMapping("member/memberView")
	public String memberView(MemberVo memberVo,
			@RequestParam(required=false) String[] hobbys) {
		String hobby="";
		if(hobbys!=null) {
			for(int i=0;i<hobbys.length;i++) {
				if(i==0) hobby += hobbys[i];
				else hobby +=","+hobbys[i];
			}
			memberVo.setHobby(hobby);
		}
		//---------------------------------------------
		
		
		
		
		return "member/memberView";
	}

}
