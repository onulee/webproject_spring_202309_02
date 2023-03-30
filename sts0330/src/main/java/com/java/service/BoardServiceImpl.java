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
	public List<BoardVo> boardSelectAll() {
		List<BoardVo> list = boardMapper.boardSelectAll();
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
		boardMapper.boardInsert(boardVo);
		System.out.println("boardInsert bno 후 : "+boardVo.getBno());
		BoardVo bVo = boardMapper.boardSelectOne(boardVo.getBno());
		return bVo;
	}

}
