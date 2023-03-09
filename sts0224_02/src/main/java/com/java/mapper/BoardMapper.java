package com.java.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.java.vo.BoardVo;
import com.java.vo.NumBoardVo;
import com.java.vo.NumBoardVo2;

@Mapper
public interface BoardMapper {

	//전체게시글 가져오기
	public List<BoardVo> selectBoardAll();

	//5개 객체 insert
	public void insertNumBoard(List<NumBoardVo> list);

	public void insertNumBoard2(List<NumBoardVo2> list);

	//public void insertNumBoard(Map<String, Object> map);

}
