package com.java.service;

import java.util.List;
import java.util.Map;

import com.java.vo.BoardVo;

public interface BoardService {
	//전체게시글 가져오기
	public Map<String,Object> selectBoardList();
	//1개게시글 가져오기
	public BoardVo selectOne(int bno);

}
