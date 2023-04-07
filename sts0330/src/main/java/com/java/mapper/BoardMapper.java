package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.vo.BoardMemberVo;
import com.java.vo.BoardVo;

@Mapper
public interface BoardMapper {
	
	//게시글 전체 가져오기
	public List<BoardVo> boardSelectAll();
	
	public BoardVo boardSelectOne(int bno);
	public BoardVo preSelectOne(int bno);
	public BoardVo nextSelectOne(int bno);

	//ajax insert
	public int boardInsert(BoardVo boardVo);

	//검색
	public List<BoardVo> boardSelectSearch(String category, String searchWord);

	public List<BoardMemberVo> boardSelectAll2();

}
