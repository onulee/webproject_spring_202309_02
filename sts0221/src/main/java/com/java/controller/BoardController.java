package com.java.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.service.BoardService;
import com.java.service.BoardServiceImpl;
import com.java.vo.BoardVo;
import com.java.vo.BoardVo2;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	//--------- [  글쓰기 페이지 ] -----------------------------------
	@GetMapping("board/fboardWrite")  //글쓰기 페이지이동
	public String fboardWrite(Model model) {
		return "board/fboardWrite";
	}
	@GetMapping("board/fboardWrite2")  //다중 글쓰기 페이지이동
	public String fboardWrite2(Model model) {
		return "board/fboardWrite2";
	}
	@GetMapping("board/fboardWrite3")  //ajax 글쓰기 페이지이동
	public String fboardWrite3(Model model) {
		return "board/fboardWrite3";
	}
	//----------------------------------------------------------------
	//------------- [ 글쓰기 저장 ] ------------------------------------ 
	@PostMapping("board/fboardWrite3")  //글쓰기 저장
	@ResponseBody
	public String fboardWrite3(BoardVo boardVo,@RequestPart MultipartFile file, Model model) {
		//업로드 파일이 없을 경우
		boardVo.setBfile("");
		
		if(!file.isEmpty()) { //file.isEmpty()
		    String originFileName = file.getOriginalFilename(); //파일이름
		    long time = System.currentTimeMillis(); // 12451715251411202
		    // a.jpg 1245041263012_a.jpg
		    String uploadFileName = String.format("%d_%s", time,originFileName);
		    String fileSaveUrl = "C:\\Users\\kv003\\git\\class202210_02\\sts0221\\src\\main\\resources\\static\\upload\\";
		    //String fileSaveUrl = "/upload";
		    File f = new File(fileSaveUrl+uploadFileName); //   /upload/122465414_a.jpg
		    try {
				file.transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		    System.out.println("fboardWrite3 uploadFileName : "+uploadFileName);
		    //변경된 파일이름을 boardVo객체 저장
		    boardVo.setBfile(uploadFileName);
		}//if
		
		boardService.insertBoard(boardVo);
		
		return "redirect:/board/fboardList";
	}//파일저장
	
	
	@PostMapping("board/fboardWrite")  //글쓰기 저장
	public String fboardWrite(BoardVo boardVo,@RequestPart MultipartFile file, Model model) {
		//업로드 파일이 없을 경우
		boardVo.setBfile("");
		
		if(!file.isEmpty()) { //file.isEmpty()
			String originFileName = file.getOriginalFilename(); //파일이름
			long time = System.currentTimeMillis(); // 12451715251411202
			// a.jpg 1245041263012_a.jpg
			String uploadFileName = String.format("%d_%s", time,originFileName);
			String fileSaveUrl = "C:\\Users\\kv003\\git\\class202210_02\\sts0221\\src\\main\\resources\\static\\upload\\";
			//String fileSaveUrl = "/upload";
			File f = new File(fileSaveUrl+uploadFileName); //   /upload/122465414_a.jpg
			try {
				file.transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
			//변경된 파일이름을 boardVo객체 저장
			boardVo.setBfile(uploadFileName);
		}//if
		
		boardService.insertBoard(boardVo);
		
		return "redirect:/board/fboardList";
	}//파일저장
	
	
	@PostMapping("board/fboardWrite2")  //다중 글쓰기 저장
	public String fboardWrite2(BoardVo2 boardVo2,@RequestPart List<MultipartFile> files, Model model) {
		//업로드 파일이 없을 경우
		boardVo2.setBfile("");
		boardVo2.setBfile2("");
		
		String[] uploadFileName = new String[2];
		
		if(!files.isEmpty()) { 
			
			for(int i=0;i<files.size();i++) {
				String originFileName = files.get(i).getOriginalFilename(); //파일이름
				long time = System.currentTimeMillis(); // 12451715251411202
				
				uploadFileName[i] = String.format("%d_%s", time,originFileName);
				String fileSaveUrl = "C:\\Users\\kv003\\git\\class202210_02\\sts0221\\src\\main\\resources\\static\\upload\\";
				File f = new File(fileSaveUrl+uploadFileName[i]); //   /upload/122465414_a.jpg
				try {
					files.get(i).transferTo(f);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				
				//변경된 파일이름을 boardVo객체 저장
				if(i==0) boardVo2.setBfile(uploadFileName[i]);
				else boardVo2.setBfile2(uploadFileName[i]);
				
				System.out.println("uploadFileName[i] : "+uploadFileName[i]);
				
			}//for
		}//if
		
		//boardService.insertBoard2(boardVo2);
		
		return "redirect:/board/fboardList";
	}//파일저장
	
	//--------------------------------------------------------------
	
	
	@GetMapping("board/fboardList") //전체게시글 가져오기
	public String fboardList(@RequestParam(defaultValue = "1") int page, Model model) {
		//모든 게시글 정보 model에 추가
		//List<BoardVo> list = boardService.selectBoardList();
		Map<String,Object> map = boardService.selectBoardList(page);
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
	
	@GetMapping("board/fboardUpdate") //게시글 수정페이지
	public String fboardUpdate(@RequestParam int bno,
			@RequestParam(defaultValue="1") int page, Model model) {
		
		BoardVo boardVo = boardService.selectOne(bno);
		model.addAttribute("boardVo",boardVo);
		model.addAttribute("page",page);
		System.out.println("fboardUpdate bno : "+bno);
		return "board/fboardUpdate";
	}
	
	@PostMapping("board/fboardUpdate")  //게시글 수정
	public String fboardUpdate(BoardVo boardVo,@RequestPart MultipartFile file, Model model) {
		
		if(!file.isEmpty()) { //file.isEmpty()
			String originFileName = file.getOriginalFilename(); //파일이름
			long time = System.currentTimeMillis(); // 12451715251411202
			String uploadFileName = String.format("%d_%s", time,originFileName);
			System.out.println("fboardUpdate uploadFileName : "+uploadFileName);
			
			String fileSaveUrl = "C:\\Users\\kv003\\git\\class202210_02\\sts0221\\src\\main\\resources\\static\\upload\\";
			//String fileSaveUrl = "/upload";
			File f = new File(fileSaveUrl+uploadFileName); //   /upload/122465414_a.jpg
			try {
				file.transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
			//변경된 파일이름을 boardVo객체 저장
			boardVo.setBfile(uploadFileName);
		}//if
		boardService.updateBoard(boardVo);
		return "redirect:/board/fboardView?bno="+boardVo.getBno();
	}//파일저장
	
	
	@GetMapping("board/fboardDelete") //게시글 삭제
	public String fboardDelete(@RequestParam int bno,
			@RequestParam(defaultValue="1") int page, Model model) {
		
		boardService.deleteBoard(bno);
		return "redirect:/board/fboardList";
	}
	
	@GetMapping("board/fboardReply") //게시글 답변달기
	public String fboardReply(@RequestParam int bno,
			@RequestParam(defaultValue="1") int page, Model model) {
		
		BoardVo boardVo = boardService.selectOne(bno);
		model.addAttribute("boardVo",boardVo);
		model.addAttribute("page",page);
		return "board/fboardReply";
	}
	
	@PostMapping("board/fboardReply") //게시글 답변달기
	public String fboardReply(BoardVo boardVo,@RequestPart MultipartFile file, Model model) {
		
		//업로드 파일이 없을 경우
		boardVo.setBfile("");
		
		if(!file.isEmpty()) { //file.isEmpty()
			String originFileName = file.getOriginalFilename(); //파일이름
			long time = System.currentTimeMillis(); // 12451715251411202
			String uploadFileName = String.format("%d_%s", time,originFileName);
			String fileSaveUrl = "C:\\Users\\kv003\\git\\class202210_02\\sts0221\\src\\main\\resources\\static\\upload\\";
			File f = new File(fileSaveUrl+uploadFileName); //   /upload/122465414_a.jpg
			try {
				file.transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			//변경된 파일이름을 boardVo객체 저장
			boardVo.setBfile(uploadFileName);
		}//if
		
		boardService.insertReply(boardVo);
		
		
		return "redirect:/board/fboardList";
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
