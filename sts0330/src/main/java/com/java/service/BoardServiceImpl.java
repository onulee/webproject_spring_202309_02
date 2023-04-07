package com.java.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.mapper.BoardMapper;
import com.java.vo.BoardMemberVo;
import com.java.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Override //게시글 전체 가져오기
	public List<BoardVo> boardSelectAll() {
		List<BoardVo> list = boardMapper.boardSelectAll();
		return list;
	}
	@Override //2개 객체 가져오기
	public List<BoardMemberVo> boardSelectAll2() {
		List<BoardMemberVo> list = boardMapper.boardSelectAll2();
		return list;
	}

	@Override //게시글 1개 가져오기
	public Map<String, Object> boardSelectOne(int bno) {
		Map<String, Object> map = new HashMap<>();
		BoardVo boardVo = boardMapper.boardSelectOne(bno);
		BoardVo nextBoardVo = boardMapper.nextSelectOne(bno);
		BoardVo preBoardVo = boardMapper.preSelectOne(bno);
		
		map.put("boardVo", boardVo);
		map.put("nextBoardVo", nextBoardVo);
		map.put("preBoardVo", preBoardVo);
		
		return map;
	}

	@Override  //ajax
	public BoardVo boardInsert(BoardVo boardVo) {
		System.out.println("boardInsert bno 전 : "+boardVo.getBno());
		// 0-실패,1-성공
		int no = boardMapper.boardInsert(boardVo);
		
		
		System.out.println("boardInsert no : "+no);
		System.out.println("boardInsert bno 후 : "+boardVo.getBno());
		BoardVo bVo = boardMapper.boardSelectOne(boardVo.getBno());
		return bVo;
	}

	@Override //검색
	public List<BoardVo> boardSelectSearch(String category, String searchWord) {
		List<BoardVo> list = boardMapper.boardSelectSearch(category,searchWord);
		return list;
	}

}
