package com.java.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.service.BoardService;
import com.java.vo.BoardVo;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	// /boardList/{page} @PathVariable 
	@GetMapping("/boardList") //리스트 페이지
	public String boardList(@RequestParam(defaultValue="1") int page,
			@RequestParam(defaultValue = "") String category,
			@RequestParam(defaultValue = "") String searchWord,	Model model) {
		
		System.out.println("BoardController page : "+page);
		// 게시글 전체 가져오기
		Map<String, Object> map = boardService.boardSelectAll(page,category,searchWord);
		
		//jsp페이지로 데이터 전달
		model.addAttribute("map",map);
		return "boardList";
	}
	
	@GetMapping("/boardWrite") //글쓰기 페이지
	public String boardWrite() {
		return "boardWrite";
	}
	
	@PostMapping("boardWrite")  // 게시글 1개 저장 - id,btitle,bcontent,bfile
	public String boardWirte(BoardVo boardVo,@RequestPart MultipartFile file ,Model model) {
		
		System.out.println("boardWirte : "+boardVo.getId());
		System.out.println("boardWirte : "+boardVo.getBtitle());
		System.out.println("boardWirte : "+boardVo.getBcontent());
		
		
		//파일첨부 없는 경우
		boardVo.setBfile("");
		
		//파일첨부가 있는 경우
		if(!file.isEmpty()) {
			String originFileName = file.getOriginalFilename(); //원본파일이름 1.jpg 
			//원본파일이름 변경작업
			long time = System.currentTimeMillis();  //1021410212141
			String uploadFileName = String.format("%d_%s",time,originFileName);
			System.out.println("uploadFileName : "+ uploadFileName);
			// 1021410212141_1.jpg
			String fileUrl = "C:/upload/";
			File f = new File(fileUrl+uploadFileName);
			
			try {
				file.transferTo(f);  //파일저장
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
			//변경된 파일이름 boardVo 저장
			boardVo.setBfile(uploadFileName);
		}
		//게시글 1개 저장
		boardService.insertBoard(boardVo);
		return "redirect:/boardList";
	}//boardWirte
	
	@GetMapping("/boardView") //게시글 1개 가져오기
	public String boardView(@RequestParam int bno, 
			@RequestParam(defaultValue="1") int page,
			@RequestParam(defaultValue = "") String category,
			@RequestParam(defaultValue = "") String searchWord,	Model model) {
		System.out.println("controller boardView : "+bno);
		BoardVo boardVo = boardService.boardSelectOne(bno);
		
		model.addAttribute("boardVo",boardVo);
		model.addAttribute("page",page);
		model.addAttribute("category",category);
		model.addAttribute("searchWord",searchWord);
		return "boardView";
	}
	
	@GetMapping("/boardDelete") //게시글 1개 삭제
	public String boardDelete(@RequestParam int bno) {
		System.out.println("controller boardDelete : "+bno);
		boardService.boardDelete(bno);
		
		return "redirect:/boardList";
	}
	
	@GetMapping("/boardUpdate") //게시글 1개 수정
	public String boardUpdate(@RequestParam int bno,Model model) {
		System.out.println("controller boardUpdate : "+bno);
		BoardVo boardVo = boardService.boardSelectOne(bno);
		model.addAttribute("boardVo",boardVo);
		return "boardUpdate";
	}
	
	@PostMapping("/boardUpdate") //게시글 1개 수정
	public String boardUpdate(BoardVo boardVo,@RequestPart MultipartFile file, 
			RedirectAttributes redirectAttributes, Model model) {
		//글수정
		System.out.println("boardUpdate id : "+boardVo.getId());
		System.out.println("boardUpdate btitle : "+boardVo.getBtitle());
		System.out.println("boardUpdate bcontent : "+boardVo.getBcontent());
		System.out.println("boardUpdate bfile: "+boardVo.getBfile());
		
		//파일첨부가 있는 경우
		if(!file.isEmpty()) {
			String originFileName = file.getOriginalFilename(); //원본파일이름 1.jpg 
			//원본파일이름 변경작업
			long time = System.currentTimeMillis();  //1021410212141
			String uploadFileName = String.format("%d_%s",time,originFileName);
			
			// 1021410212141_1.jpg
			String fileUrl = "C:/upload/";
			File f = new File(fileUrl+uploadFileName);
			
			try {
				file.transferTo(f);  //파일저장
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
			//변경된 파일이름 boardVo 저장
			boardVo.setBfile(uploadFileName);
			System.out.println("uploadFileName : "+ uploadFileName);
		}
		//게시글 1개 수정
		boardService.updateBoard(boardVo);
		
		//redirect 데이터 전달방법
		redirectAttributes.addAttribute("result","success");
		return "redirect:/boardList";
	}
	
	

}
