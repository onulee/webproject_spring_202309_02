package com.java.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.java.vo.BoardVo;

public interface BoardService {

	Page<BoardVo> boardFindAll(Pageable pageable);

	Map<String, Object> boardFindById(int bno) throws Exception;

	void deleteById(int bno);

	int save(BoardVo boardVo);

	int update(BoardVo boardVo);

}
