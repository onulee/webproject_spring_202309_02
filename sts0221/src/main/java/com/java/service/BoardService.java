package com.java.service;

import java.util.List;
import java.util.Map;

import com.java.vo.BoardVo;

public interface BoardService {
	//전체게시글 가져오기
	public Map<String,Object> selectBoardList(int page);
	//1개게시글 가져오기
	public BoardVo selectOne(int bno);
	
	//파일 첨부 저장
	public void insertBoard(BoardVo boardVo);
	
	//게시글 수정
	public void updateBoard(BoardVo boardVo);
	
	//게시글 삭제
	public void deleteBoard(int bno);
	
	//게시글 답변달기
	public void insertReply(BoardVo boardVo);

}
