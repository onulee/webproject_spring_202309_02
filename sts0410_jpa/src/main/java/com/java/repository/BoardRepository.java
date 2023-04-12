package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.vo.BoardVo;

public interface BoardRepository extends JpaRepository<BoardVo, Integer> {

	//save
	
	//findAll
	
	//findById
	
	//deleteById
	
	//이전 게시글
	@Query(value="SELECT * FROM boardvo "
			+ "WHERE bno = (SELECT prev_bno FROM (SELECT bno, "
			+ "LAG(bno, 1, -1) OVER(order by topchk desc,bgroup desc,bstep asc) AS prev_bno "
			+ "FROM boardvo) B WHERE bno = :bno)", nativeQuery = true)
	BoardVo findPrev(int bno);

	//다음 게시글
	@Query(value="SELECT * FROM boardvo "
			+ "WHERE bno = (SELECT next_bno FROM (SELECT bno, "
			+ "LEAD(bno, 1, -1) OVER(order by topchk desc,bgroup desc,bstep asc) AS next_bno "
			+ "FROM boardvo) B WHERE bno = :bno)", nativeQuery = true)
	BoardVo findNext(int bno);

}
