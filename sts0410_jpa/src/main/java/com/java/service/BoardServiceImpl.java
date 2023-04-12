package com.java.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

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

	
	//게시글 1개 가져오기
	@Override
	public Map<String, Object> boardFindById(int bno) throws Exception {
		Map<String, Object> map = new HashMap<>();
		
		//4. 람다식 예외처리
		BoardVo boardVo = boardRepository.findById(bno).orElseThrow(
				()->{
					return new IllegalAccessException(bno+"번 해당 게시글이 없습니다.");
				}
		);
		
		//이전글 - 메소드신규생성
		BoardVo preBvo = boardRepository.findPrev(bno);
		System.out.println("preBvo : "+preBvo.getBno());
		
		//다음글
		BoardVo nextBvo = boardRepository.findNext(bno);
		System.out.println("nextBvo : "+nextBvo.getBno());
		
		map.put("boardVo",boardVo);
		map.put("preBvo",preBvo);
		map.put("nextBvo",nextBvo);
		
		return map;
		
//		1. findeById().get() 에러가 없음. 무조건 가져오기
//		BoardVo boardVo = boardRepository.findById(bno).get();
//		2. null일때 빈 객체를 리턴
//		BoardVo boardVo = boardRepository.findById(bno).orElseGet(
//				new Supplier<BoardVo>() {
//					@Override
//					public BoardVo get() {
//						return new BoardVo();
//					}
//				}
//		);
		//3. orElseThrow() 예외처리
//		BoardVo boardVo = boardRepository.findById(bno).orElseThrow(
//				new Supplier<IllegalAccessException>() {
//					@Override
//					public IllegalAccessException get() {
//						return new IllegalAccessException(bno+"번 해당 게시글이 없습니다.");
//					}
//				}
//		);
		
		
	}

}
