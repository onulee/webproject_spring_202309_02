package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.service.BoardService;
import com.java.vo.BoardVo;

@Controller
public class FController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("write")
	public String write() {
		return "write";
	}
	
	@PostMapping("write")
	@ResponseBody
	public String write(BoardVo boardVo, Model model) {
		System.out.println("FController getBtitle :  "+boardVo.getBtitle());
		System.out.println("FController getBcontent :  "+boardVo.getBcontent());
		System.out.println("FController getId :  "+boardVo.getId());
		return "success";
	}
	
	
	@RequestMapping("numboard")
	public String numboard() {
		boardService.insertNumBoard();
		return "numboard";
	}
	
	@RequestMapping("numboard2")
	public String numboard2() {
		boardService.insertNumBoard2();
		return "numboard2";
	}
	
	

}
