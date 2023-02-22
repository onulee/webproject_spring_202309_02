<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>자유게시판</title>
		<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
		  a{text-decoration: none;}
		  table,th,td{border:1px solid black; border-collapse: collapse; }
		  h2{text-align: center;}
		  table{width:920px; margin: 0 auto; text-align: center; }
		  th,td{height:40px;}
		  tr td:nth-of-type(2){text-align: left; padding-left:40px; box-sizing: border-box;}
		  div{width: 250px; height:60px; margin:12px auto 0;   }
		  button{display: inline-block; width:120px; height:40px; }
		  .img{width:10px;}
		  .material-symbols-outlined {
			  font-variation-settings:
			  'FILL' 0,
			  'wght' 200,
			  'GRAD' 0,
			  'opsz' 22
			}
			.searchDiv{width:470px; height:40px; margin:50px auto 20px; }
			.searchDiv select{width: 80px; height:40px; font-size: 15px;}
			.searchDiv input{width: 250px; height:35px; font-size: 15px;}
			.numbering{width:460px; height:40px; margin:20px auto 40px; text-align: center;}
			.numbering span{width:40px; height:40px; display: inline-block; border:1px solid black; 
			box-sizing: border-box; text-align: center; font-size:15px; padding-top:9px;}
			#on{background: #e56e00; color:#fff; }
			img{width:300px;}
		</style>
		<script>
		  function publicBtn(){
			  alert("공공데이터 검색합니다.");
			  var formData={"id":"aaa"};
			  $.ajax({
				 url:"publicSearch",
				 type:"post",
				 data:formData,
				 dataType:"json", //데이터를 받을때 json타입
				 success:function(data){
					 var dataArr = data.response.body.items.item;
					 alert("성공");
					 console.log(data);
					 console.log("1 data : "+dataArr[0]);
					 console.log("1 data.galTitle : "+dataArr[0].galTitle);
					 
					 var htmlData="";
					 
					 for(var i=0;i<dataArr.length;i++){
						 htmlData +='<tr>';
						 htmlData +='<td>'+dataArr[i].galTitle+'</td>';
						 htmlData +='<td>'+dataArr[i].galPhotographyLocation+'</td>';
						 htmlData +='<td>'+dataArr[i].galPhotographer+'</td>';
						 htmlData +='<td>'+dataArr[i].galModifiedtime+'</td>';
						 htmlData +='<td><img src=\"'+dataArr[i].galWebImageUrl+'\"></td>';
						 htmlData +='</tr>';
					 }
					 
					 $("#tbody").html(htmlData);
					 
				 },
				 error:function(){
					 alert("실패");
				 }
			  });
		  }
		  
		//id를 체크
		  function checkIdBtn(){
			  
		  } 
		</script>
	</head>
	<body>
		<h2>자유게시판</h2>
		<div class="searchDiv">
		  <form action="doBoardSearch.do" method="get" name="searchFrm">
		    <select name="searchTitle" id="searchTitle">
		       <option value="all">전체</option>
		       <option value="btitle">제목</option>
		       <option value="bcontent">내용</option>
		       <option value="id">작성자</option>
		    </select>
		    <input type="text" name="searchWord" id="searchWord">
		    <button type="button" onclick="publicBtn()">공공데이터검색</button>
		  </form>
		</div>
		<table>
		   <colgroup>
		     <col width="20%">
		     <col width="20%">
		     <col width="15%">
		     <col width="15%">
		     <col width="30%">
		   </colgroup>
			<tr>
			  <th>사진제목</th>
			  <th>촬영장소</th>
			  <th>촬영자</th>
			  <th>촬영일</th>
			  <th>이미지</th>
			</tr>
			<tbody id="tbody">
				<tr>
				  <td>1</td>
				  <td>게시글 제목</td>
				  <td>아이디</td>
				  <td>날짜입니다.</td>
				  <td>1</td>
				</tr>
			</tbody>
		</table>
		<div class="numbering">
		<!-- 첫페이지 이동  -->
		<span>&#171;</span>
		<!-- 이전페이지 이동 -->
		<span>&#60;</span>
		<!-- 하단넘버링부분 -->
		<span>1</span>
		<!-- 다음페이지 이동 -->
  		<span>&#62;</span>
		<!-- 끝페이지 이동 -->
		<span>&#187;</span>
		</div>
		
		<div>
		  <a href=""><button type="button">글쓰기</button></a>
		  <a href="/"><button type="button">메인페이지</button></a>
		</div>
	</body>
</html>