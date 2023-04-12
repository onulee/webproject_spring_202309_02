package com.java.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.vo.MemberVo;

public interface MemberRepository extends JpaRepository<MemberVo, String> {

	//findById("aaa") -> select * from MemberVo where id="aaa"
	//findByIdAndPw(id,pw) -> select * from MemberVo where id=:id and pw=:pw
	MemberVo findByIdAndPw(String id, String pw);
	
	@Query(value="select * from membervo where id=? and pw=?", nativeQuery = true )
	MemberVo login(String id, String pw);

}
