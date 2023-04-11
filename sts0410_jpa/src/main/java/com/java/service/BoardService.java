package com.java.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.java.vo.BoardVo;

public interface BoardService {

	Page<BoardVo> boardFindAll(Pageable pageable);

}
