package com.java.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.repository.BoardRepository;
import com.java.vo.BoardVo;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardRepository boardRepository;
	
	@PersistenceContext
	private EntityManager em;
	
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
		//System.out.println("preBvo : "+preBvo.getBno());
		
		//다음글
		BoardVo nextBvo = boardRepository.findNext(bno);
		//System.out.println("nextBvo : "+nextBvo.getBno());
		
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


	//1개 게시글 삭제하기
	@Override
	public void deleteById(int bno) {
		boardRepository.deleteById(bno);
	}


	//1개 게시글 저장
	@Transactional
	@Override
	public int save(BoardVo boardVo) {
		//bno => boardvo_seq.nextval, bgroup => boardvo_seq.currval
		em.persist(boardVo); // 임시저장 - 시퀀스번호 생성
		boardVo.setBgroup(boardVo.getBno()); //시퀀스 번호를 가지고 와서 bgroup저장
		boardVo.setBdate(new Timestamp(System.currentTimeMillis()));
		BoardVo result = boardRepository.save(boardVo); //db저장
		//result.setBgroup(result.getBno()); //db에 저장된 시퀀스 번호를 가져와 다시 저장
		// 시퀀스 번호 출력
		System.out.println("result : "+ result.getBno() );
		
		return 0;
	}


	@Transactional
	@Override
	public int update(BoardVo boardVo) {
		boardVo.setBdate(new Timestamp(System.currentTimeMillis()));
		BoardVo result = boardRepository.save(boardVo); //db저장
		System.out.println("update : "+ result.getBno());
		return 0;
	}

}
