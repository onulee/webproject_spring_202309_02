package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.vo.MemberVo;

public interface MemberRepository extends JpaRepository<MemberVo, String> {

}
