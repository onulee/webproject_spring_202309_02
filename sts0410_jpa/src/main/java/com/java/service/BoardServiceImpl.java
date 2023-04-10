package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.repository.BoardRepository;
import com.java.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardRepository boardRepository;
	
	@Override
	public List<BoardVo> boardFindAll() {
		//JpaRepository findAll 함수호출 list리턴
		List<BoardVo> list = boardRepository.findAll();
		return list;
	}

}
