package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.java.repository.BoardRepository;
import com.java.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardRepository boardRepository;
	
	@Override
	public Page<BoardVo> boardFindAll(Pageable pageable) {
		//다중정렬
		Sort sort = Sort.by(
			Sort.Order.desc("topchk"),
			Sort.Order.desc("bgroup"),
			Sort.Order.asc("bstep")
		);

		//JpaRepository findAll 함수호출 list리턴
		Page<BoardVo> page = boardRepository.findAll(pageable);
		return page;
	}

}
