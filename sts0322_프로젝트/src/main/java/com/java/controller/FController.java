package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.service.BoardService;
import com.java.vo.BoardVo;

@Controller
public class FController {
	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	

}
