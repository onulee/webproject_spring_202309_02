package com.java.service;

import java.util.List;
import java.util.Map;

import com.java.vo.BoardVo;

public interface BoardService {

	//게시글 전체 가져오기 - 리턴타입 Map
	Map<String, Object> boardSelectAll(int page, String category, String searchWord);

	//게시글 1개 저장
	void insertBoard(BoardVo boardVo);

	//게시글 1개 가져오기
	BoardVo boardSelectOne(int bno);

	//게시글 1개 삭제
	void boardDelete(int bno);

	//게시글 1개 수정
	void updateBoard(BoardVo boardVo);


}
