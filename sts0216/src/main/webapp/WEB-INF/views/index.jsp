<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index</title>
	</head>
	<body>
	  <h2>메인페이지</h2>
	  <h3>로그인을 하셔야 글을 입력할 수 있습니다.</h3>
	  <ul>
	    <li><a href="login">로그인</a></li>
	    <li><a href="member/memberWrite">회원가입</a></li>
	    <li><a href="board/publicDataList">공공데이터검색</a></li>
	  </ul>
	  <h3>홍길동님 환영합니다.</h3>
	  <ul>
	    <li><a href="board/fboardWrite">글쓰기</a></li>
	    <li><a href="fboardList">자유게시판</a></li>
	    <li><a href="logout">로그아웃</a></li>
	    <li>회원정보수정</li>
	    <li><a href="memberAll">전체회원보기</a></li>
	  </ul>
	
	</body>
</html>