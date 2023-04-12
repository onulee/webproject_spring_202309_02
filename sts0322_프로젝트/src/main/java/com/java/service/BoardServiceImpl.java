package com.java.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.mapper.BoardMapper;
import com.java.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Override //게시글 전체 가져오기
	public Map<String, Object> boardSelectAll(int page,String category, String searchWord) {
		Map<String, Object> map = new HashMap<>();
		//페이지 호출
		map = pageMethod(page,category,searchWord);
		int startRow = (int)map.get("startRow");
		int endRow = (int)map.get("endRow");
		List<BoardVo> list = boardMapper.boardSelectAll(category,searchWord,startRow,endRow);
		map.put("list", list);
		
		return map;
	}
	
	
	//하단넘버링 페이지호출
	public Map<String, Object> pageMethod(int page,String category,String searchWord){
		Map<String, Object> map = new HashMap<>();
		//page:현재페이지, listCount:총개수, maxpage:최대페이지,startpage,endpage,startrow,endrow
		int rowPerPage = 10; //1페이지 10개씩 가져오기
		int pageList = 5;    // 하단넘버링 개수
		
		int listCount = boardMapper.selectCount(category,searchWord); 
		int maxPage = (int) Math.ceil((double)listCount/rowPerPage); //최대페이지수
		int startPage = ((page-1)/pageList)*pageList + 1; //하단넘버링 시작
		int endPage = startPage+pageList-1;           //하단넘버링 끝
		if(endPage>maxPage) endPage=maxPage;
		int startRow = (page-1)*10+1;  //3  1-10,11-20,21-30
		int endRow = startRow+10-1;
		
		map.put("listCount", listCount);
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("page", page);
		map.put("category", category);
		map.put("searchWord", searchWord);
		
		return map;
	}
	

	@Override //게시글 1개 저장
	public void insertBoard(BoardVo boardVo) {
		boardMapper.insertBoard(boardVo);
		
	}

	@Override //게시글 1개 가져오기
	public BoardVo boardSelectOne(int bno) {
		BoardVo boardVo = boardMapper.boardSelectOne(bno);
		return boardVo;
	}

	@Override //게시글 1개 삭제
	public void boardDelete(int bno) {
		boardMapper.boardDelete(bno);
		
	}

	@Override //게시글 1개 수정
	public void updateBoard(BoardVo boardVo) {
		boardMapper.updateBoard(boardVo);
		
	}


	

}
