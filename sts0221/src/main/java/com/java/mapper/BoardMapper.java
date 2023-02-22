package com.java.mapper;


import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.java.vo.BoardVo;


@Mapper //sqlSessionTemplate
public interface BoardMapper {

	public List<BoardVo> selectBoardList(int startrow, int endrow);

	public int selectCount();

	public BoardVo selectOne(int bno);
	
	//조회수 1증가
	public void updateBhitUp(int bno);

	//게시글 저장:파일첨부
	public void insertBoard(BoardVo boardVo);

	//게시글 수정
	public void updateBoard(BoardVo boardVo);

	//게시글 삭제
	public void deleteBoard(int bno);

	//게시글 답변달기
	public void insertReply(BoardVo boardVo);

	//게시글 답변달기 step 1증가
	public void updateReplyStepUp(BoardVo boardVo);

	
}








