package com.java.mapper;


import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.java.vo.BoardVo;


@Mapper //sqlSessionTemplate
public interface BoardMapper {

	public List<BoardVo> selectBoardList();

	public int selectCount();

	public BoardVo selectOne(int bno);
	
}








