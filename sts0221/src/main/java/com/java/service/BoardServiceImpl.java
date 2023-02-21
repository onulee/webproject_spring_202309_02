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
	
	@Override //전체게시글 가져오기
	public Map<String,Object> selectBoardList() {
		Map<String,Object> map = new HashMap<>();
		//전체게시글 가져오기
		List<BoardVo> list = boardMapper.selectBoardList();
		//page:현재페이지,listCount:총개수,maxpage:최대페이지,startpage,endpage,startrow,endrow
		
		int listCount = boardMapper.selectCount();
		System.out.println("BoardServiceImpl listCount : "+listCount);
		map.put("list",list);
		map.put("page",1);
		map.put("listCount",listCount);
		
		return map;
	}//selectBoardList

	@Override //1개게시글 가져오기
	public BoardVo selectOne(int bno) {
		BoardVo boardVo = boardMapper.selectOne(bno);
		
		
		return boardVo;
	}//selectOne

}
