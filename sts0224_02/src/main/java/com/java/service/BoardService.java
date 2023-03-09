package com.java.service;

import java.util.List;

import com.java.vo.BoardVo;

public interface BoardService {

	List<BoardVo> selectBoardAll();
	
	int insertNumBoard();

	void insertNumBoard2();

}
