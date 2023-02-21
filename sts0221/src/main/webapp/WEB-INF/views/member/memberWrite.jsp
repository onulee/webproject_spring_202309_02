<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		  h2{text-align: center;}
		  table{width:920px; margin: 0 auto; text-align: center; }
		  th,td{height:40px;}
		  td{ text-align: left; padding-left:30px; }
		  input{width:575px; height:30px; }
		  div{width: 400px; height:60px; margin:12px auto 0;  }
		  button{display: inline-block; width:120px; height:40px; }
		  #content{height:300px;}
		  .type1 input { width:20px; height:15px;}
		</style>
		<script>
		  function memberBtn(){
			  if($("#id").val().length<2){
				  alert("아이디는 두글자 이상 입력하셔야 합니다.");
				  $("#id").focus();
				  return;
			  }
			  
			  if(confirm("회원가입을 하시겠습니까?")){
			    return memberFrm.submit();
			  } 
		  }
		
		  function cancelBtn(){
			  if(confirm("회원가입을 취소하시겠습니까?")) location.href="/";
		  }
		  
		  
		  //id를 체크
		  function checkIdBtn(){
			  alert("ID를 체크합니다.");
			  var formData={"id":$("#id").val()};
			  $.ajax({
				 url:"checkId",
				 type:"post",
				 //기본타입전송 - form데이터로 전송 
				 //data:formData,
				 
				 // json타입 전송
				 data:JSON.stringify(formData), //form데이터를 json타입으로 변경
				 contentType:"application/json; charset=utf-8;",//데이터를 보낼때 json타입
				 
				 dataType:"json", //데이터를 받을때 json타입
				 success:function(data){
					 alert("성공");
					 console.log(data);
					 console.log("name : "+data[0].name);
					 console.log("age : "+data[0].age);
					 console.log("id : "+data.id);
					 console.log("pw : "+data.pw);
				 },
				 error:function(){
					 alert("실패");
				 }
			  });
		  } 
		</script>
	</head>
	<body>
		<h2>회원가입</h2>
		<form action="memberView" method="post" name="memberFrm" >
		<table>
		   <colgroup>
		     <col width="30%">
		     <col width="70%">
		   </colgroup>
			<tr>
			  <th>아이디</th>
			  <td>
			    <input type="text" name="id" id="id"><br>
			    <button type="button" onclick="checkIdBtn()">중복확인</button>
			  </td>
			</tr>
			<tr>
			  <th>패스워드</th>
			  <td><input type="text" name="pw" id="pw"></td>
			</tr>
			<tr>
			  <th>패스워드확인</th>
			  <td><input type="password" name="pw2" id="pw2"></td>
			</tr>
			<tr>
			  <th>이름</th>
			  <td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
			  <th>전화번호</th>
			  <td><input type="text" name="phone" id="phone"></td>
			</tr>
			<tr>
			  <th>성별</th>
			  <td class="type1">
			    <input type="radio" name="gender" id="male" value="male">
			    <label for="male">남자</label>
			    <input type="radio" name="gender" id="female" value="female">
			    <label for="female">여자</label>
			  </td>
			</tr>
			<tr>
			  <th>취미</th>
			  <td class="type1">
			    <input type="checkbox" name="hobbys" id="swim" value="swim">
			    <label for="swim">수영</label>
			    <input type="checkbox" name="hobbys" id="golf" value="golf">
			    <label for="golf">골프</label>
			    <input type="checkbox" name="hobbys" id="game" value="game">
			    <label for="game">게임</label>
			    <input type="checkbox" name="hobbys" id="run" value="run">
			    <label for="run">조깅</label>
			    <input type="checkbox" name="hobbys" id="book" value="book">
			    <label for="book">독서</label>
			  </td>
			</tr>
		</table>
		<div>
		  <button type="button" onclick="memberBtn()">완료</button>
		  <button type="button" onclick="cancelBtn()" >취소</button>
		</div>
		</form>
	
	</body>
</html>