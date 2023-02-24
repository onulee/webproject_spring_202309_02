package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.vo.BoardVo;

@Mapper
public interface BoardMapper {

	//전체게시글 가져오기
	public List<BoardVo> selectBoardAll();

}
