package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController // 데이터만 돌려주는 controller
@Controller
public class FController {
	
	@GetMapping({"/","/index"})
	public String index() {
		return "index";
	}

}
