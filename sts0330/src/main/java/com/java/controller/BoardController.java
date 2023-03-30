package com.java.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.service.BoardService;
import com.java.vo.BoardVo;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService; 
	
	@GetMapping("/board/boardList")
	public String boardList(Model model) {
		//게시글 전체 가져오기
		List<BoardVo> list = boardService.boardSelectAll();
		model.addAttribute("list",list);
		return "boardList";
	}
	@GetMapping("/board/boardList2")
	public String boardList2() {
		//게시글 전체 가져오기
		//List<BoardVo> list = boardService.boardSelectAll();
		return "boardList2";
	}
	
	
	//ajax 게시글 전체 가져오기
	@PostMapping("/board/boardWrite")
	@ResponseBody //데이터로 전송
	public BoardVo boardWrite(BoardVo boardVo) {
		System.out.println("boardController boardWrite : "+boardVo.getId());
		System.out.println("boardController boardWrite : "+boardVo.getBtitle());
		System.out.println("boardController boardWrite : "+boardVo.getBcontent());
		// 게시글 1개를 저장해서, 저장한 게시글을 가져오기
		BoardVo bVo = boardService.boardInsert(boardVo);
		return bVo;
	}
	
	//ajax 게시글 전체 가져오기
	@PostMapping("/board/boardList_ajax")
	@ResponseBody //데이터로 전송
	public List<BoardVo> boardList_ajax() {
		List<BoardVo> list = boardService.boardSelectAll();
		return list;
	}
	
	@GetMapping("/board/boardView")
	public String boardView(@RequestParam(defaultValue = "1") int bno, Model model) {
		//게시글 1개 가져오기
		Map<String, Object> map = boardService.boardSelectOne(bno);
		model.addAttribute("map",map);  //map.boardVo  map.nextBoardVo  map.preBoardVo
		return "boardView";
	}

}
