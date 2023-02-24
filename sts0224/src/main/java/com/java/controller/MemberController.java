package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	@GetMapping("member/join02_info_input")
	public String join02_info_input() {
		return "member/join02_info_input";
	}
}
