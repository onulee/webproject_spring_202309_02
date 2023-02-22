<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원정보</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		  h2{text-align: center;}
		  table{width:920px; margin: 0 auto; text-align: center; }
		  th,td{height:40px;}
		  td{ text-align: left; padding-left:30px; }
		  div{width: 500px; height:60px; margin:12px auto 0;  }
		  button{display: inline-block; width:120px; height:40px; }
		  #content{height:500px;}
		  img{width:500px;}
		</style>
		<script>
		   function deleteBtn(){
			   if(confirm("게시글을 삭제하시겠습니까?")) location.href="doFboardDelete.do?bno=${bBean.bno}&page=${page}&searchTitle=${searchTitle}&searchWord=${searchWord}";
		   }
		   function updateBtn(){
			   if(confirm("게시글을 수정하시겠습니까?")) location.href="fboardUpdate.do?bno=${bBean.bno}&page=${page}&searchTitle=${searchTitle}&searchWord=${searchWord}";
		   }
		</script>
	</head>
	<body>
		<h2>회원정보</h2>
		<table>
		   <colgroup>
		     <col width="30%">
		     <col width="70%">
		   </colgroup>
			<tr>
			  <th>아이디</th>
			  <td>${memberVo.id}</td>
			</tr>
			<tr>
			  <th>패스워드</th>
			  <td>${memberVo.pw}</td>
			</tr>
			<tr>
			  <th>이름</th>
			  <td>${memberVo.name}</td>
			</tr>
			<tr>
			  <th>전화번호</th>
			  <td>${memberVo.phone}</td>
			</tr>
			<tr>
			  <th>성별</th>
			  <td>${memberVo.gender}</td>
			</tr>
			<tr>
			  <th>취미</th>
			  <td>${memberVo.hobby}</td>
			</tr>
			
		</table>
		<div>
		  <a href="/"><button type="button">메인페이지</button></a>
		  <a href="memberWrite"><button type="button">회원등록</button></a>
		  <button type="button" onclick="updateBtn()">수정</button>
		  <button type="button" onclick="deleteBtn()">삭제</button>
		</div>
	
	</body>
</html>