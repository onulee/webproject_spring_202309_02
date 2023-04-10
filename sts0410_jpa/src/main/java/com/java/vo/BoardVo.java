package com.java.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity //jpa생성
@SequenceGenerator(
 name="boardvo_seq_generator",  //컬럼부분에 넣을 이름
 sequenceName = "boardvo_seq",  //오라클 테이블 시퀀스 생성이름
 initialValue = 1,               //start 1부터 시작
 allocationSize = 1              //증가 1
)
public class BoardVo {
	
	@Id //오라클에서 시퀀스생성
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator = "boardvo_seq_generator")
	private int bno;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id")    //FK키로 등록
	private MemberVo memberVo;  //member객체 저장 id
	
	@Column(nullable = false,length = 100)
	private String btitle;
	
	@Lob //대용량 글자
	private String bcontent;
	
	@CreationTimestamp
	private Timestamp bdate;
	
	@ColumnDefault("0") //자동으로 0입력
	private int bstep;
	
	@ColumnDefault("1") //자동으로 1입력
	private int bhit;
	
	private int bgroup;
	@ColumnDefault("0") //자동으로 0입력
	private int bindent;
	
	private String bfile;
	@ColumnDefault("0") //자동으로 0입력
	private int topchk;

}
