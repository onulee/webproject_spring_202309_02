package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.service.BoardService;
import com.java.vo.BoardVo;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	
	@GetMapping("/board/boardList")
	public String boardList(Model model) {
		
		List<BoardVo> list = boardService.boardFindAll();
		
		model.addAttribute("list",list);
		return "board/boardList";
	}
}
