package com.java.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.service.BoardService;
import com.java.service.BoardServiceImpl;
import com.java.vo.BoardVo;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@GetMapping("board/fboardWrite")
	public String fboardWrite(Model model) {
		return "board/fboardWrite";
	}
	
	@GetMapping("board/fboardList") //전체게시글 가져오기
	public String fboardList(Model model) {
		//모든 게시글 정보 model에 추가
		//List<BoardVo> list = boardService.selectBoardList();
		Map<String,Object> map = boardService.selectBoardList();
		model.addAttribute("map",map);
		
		return "board/fboardList";
	}
	
	
	@RequestMapping("board/fboardView")//1개 게시글 가져오기
	public String fboardView(@RequestParam int bno,
			@RequestParam(defaultValue="1") int page, Model model) {
		
		BoardVo boardVo = boardService.selectOne(bno);
		
		model.addAttribute("boardVo",boardVo);
		model.addAttribute("page",page);
		
		return "board/fboardView";
	}
	
	
	
	
	
	
//	@PostMapping("board/fboardView")
//	public String fboardView(@RequestParam(required=false,defaultValue="1") int id,@RequestParam String btitle, Model model) {
//		model.addAttribute("id",id);
//		model.addAttribute("btitle",btitle);
//		return "board/fboardView";
//	}
	
	//HttpServletRequest
//	@PostMapping("board/fboardView")
//	public String fboardView(HttpServletRequest request, Model model) {
//		int id = Integer.parseInt(request.getParameter("id"));
//		model.addAttribute("id",id);
//		return "board/fboardView";
//	}
	
	
	
	
	
}
