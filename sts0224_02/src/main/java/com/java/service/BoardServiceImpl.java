package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.mapper.BoardMapper;
import com.java.vo.BoardVo;
import com.java.vo.NumBoardVo;
import com.java.vo.NumBoardVo2;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Override //전체게시글 가져오기
	public List<BoardVo> selectBoardAll() {
		List<BoardVo> list = boardMapper.selectBoardAll();
		
		
		return list;
	}

	@Override
	public int insertNumBoard() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<NumBoardVo> list = new ArrayList<>();
		for(int i=1;i<=5;i++) {
			
			list.add(new NumBoardVo(i,"abcd","1111"));
		}
		//map.put("list", list);// map에 객체 arraylist  담기
		//boardMapper.insertNumBoard(map);
		boardMapper.insertNumBoard(list);
		
		return 0;
	}

	@Override
	public void insertNumBoard2() {
		List<NumBoardVo2> list = new ArrayList<>();
		for(int i=4;i<=5;i++) {
			list.add(new NumBoardVo2(i,"abcd","1111"));
		}
		//boardMapper.insertNumBoard(map);
		boardMapper.insertNumBoard2(list);
		
		
	}

}
