package com.java.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.data.web.SortDefault.SortDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.service.BoardService;
import com.java.vo.BoardVo;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@GetMapping("/board/boardView")
	public String boardView(@RequestParam(defaultValue = "1") int bno,
			@RequestParam(defaultValue = "0") int page,Model model) throws Exception {
		System.out.println("boardView bno : "+bno);
	
		// 게시글 1개 가져오기  findAll,findById,save-(insert,update),Delete
		Map<String, Object> map = boardService.boardFindById(bno);
		
		model.addAttribute("boardVo",map.get("boardVo"));
		model.addAttribute("preBvo",map.get("preBvo"));
		model.addAttribute("nextBvo",map.get("nextBvo"));
		
		return "board/boardView";
	}
	
	
	// 게시글 전체 가져오기
	@GetMapping("/board/boardList")
	// page=0부터 시작,size : 1개페이지에 10개 게시글리스트,정렬 SortDefaults
	public String boardList(@PageableDefault(page=0,size=10) 
	        @SortDefaults({ @SortDefault(sort="topchk",direction = Sort.Direction.DESC),
	        		@SortDefault(sort="bgroup",direction=Sort.Direction.DESC),
	        		@SortDefault(sort="bstep",direction=Sort.Direction.ASC)}) Pageable pageable,
			Model model) {
		
		Page<BoardVo> page = boardService.boardFindAll(pageable);
		List<BoardVo> list = page.getContent();  //게시글 List
		
//		총페이지  : page.getTotalPages()
//      총개수 : page.totalElements();
//      현재 페이지 : page.getNumber();
		
		int nowPage = page.getNumber(); //현재페이지 0부터 시작해서 +1
		int startPage = (nowPage/10)*10;  //1,11,21,31
		int endPage = Math.min(startPage+10-1,page.getTotalPages()-1); //10,20,30..
		
		model.addAttribute("list",list);                     //전체게시글수
		model.addAttribute("page",nowPage);                  //현재 페이지
		model.addAttribute("startPage",startPage);           //시작페이지
		model.addAttribute("endPage",endPage);               //끝 페이지
		model.addAttribute("maxPage",page.getTotalPages());  //총페이지수

		return "board/boardList";
	}
}
