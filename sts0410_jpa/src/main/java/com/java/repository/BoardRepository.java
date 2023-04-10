package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.vo.BoardVo;

public interface BoardRepository extends JpaRepository<BoardVo, Integer> {

}
