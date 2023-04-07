package com.java.service;

import java.util.List;
import java.util.Map;

import com.java.vo.BoardMemberVo;
import com.java.vo.BoardVo;

public interface BoardService {

	//게시글 전체 가져오기
	List<BoardVo> boardSelectAll();

	//게시글 1개 가져오기
	Map<String, Object> boardSelectOne(int bno);

	//ajax 
	BoardVo boardInsert(BoardVo boardVo);

	//검색
	List<BoardVo> boardSelectSearch(String category, String searchWord);

	List<BoardMemberVo> boardSelectAll2();

}
