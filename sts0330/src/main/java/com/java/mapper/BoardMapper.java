package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.vo.BoardVo;

@Mapper
public interface BoardMapper {
	
	//게시글 전체 가져오기
	public List<BoardVo> boardSelectAll();
	
	public BoardVo boardSelectOne(int bno);
	public BoardVo preSelectOne(int bno);
	public BoardVo nextSelectOne(int bno);

	//ajax insert
	public void boardInsert(BoardVo boardVo);

}
