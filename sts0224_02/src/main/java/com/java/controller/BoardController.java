package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.service.BoardService;
import com.java.vo.BoardVo;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	
	@RequestMapping("board/boardList")
	public String boardList(Model model) {
		//전체 게시글 가져오기
		List<BoardVo> list = boardService.selectBoardAll();
		model.addAttribute("list",list);
		model.addAttribute("page",1);
		model.addAttribute("startpage",1);
		model.addAttribute("endpage",3);
		model.addAttribute("maxpage",3);
		
		return "board/boardList";
	}//boardList
	
	@GetMapping("board/boardWrite")
	public String boardWrite() {
		return "board/boardWrite";
	}

}
