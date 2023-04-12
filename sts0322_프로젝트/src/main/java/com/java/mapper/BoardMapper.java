package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.vo.BoardVo;

@Mapper
public interface BoardMapper {

	//게시글 전체 가져오기
	List<BoardVo> boardSelectAll(String category, String searchWord, int startRow, int endRow);
	//게시글 1개 가져오기
	BoardVo boardSelectOne(int bno);
	//게시글 총개수
	int selectCount(String category, String searchWord);

	
	//게시글 1개 저장
	void insertBoard(BoardVo boardVo);
	
	//게시글 1개 수정
	void updateBoard(BoardVo boardVo);
	
	//게시글 1개 삭제
	void boardDelete(int bno);
	

	

	

}
