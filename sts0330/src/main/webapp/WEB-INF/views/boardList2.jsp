<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <title>Document</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="/css/notice_list.css">
  <script>
    $(function(){
    	$.ajax({
    		url:"/board/boardList_ajax",
    		type:"post",
    		dataType:"json",
    		data:{},
    		success:function(data){  //list
    			alert("데이터를 가져옵니다.");
    			var dataHtml ="";
    			for(var i=0;i<data.length;i++){
    				dataHtml += '<tr>';
    				dataHtml += '<td>'+data[i].bno+'</td>';
    				dataHtml += '<td class="table-title">'+data[i].btitle+'</td>';
    				dataHtml += '<td>'+data[i].id+'</td>';
    				dataHtml += '<td>'+data[i].bdate+'</td>';
    				dataHtml += '<td>'+data[i].bhit+'</td>';
    				dataHtml += '</tr>';
    			}
    			
    			$("#tbody").html(dataHtml);
    			
    		},
    		error:function(){
    			alert("실패");
    		}
    	});
    	
    	$("#writeBtn").on("click",function(){
    		alert("쓰기 버튼 클릭");
    		alert($("#id").val());
    		alert($("#btitle").val());
    		alert($("#bcontent").val());
    		//ajax
    		$.ajax({
        		url:"/board/boardWrite",
        		type:"post",
        		dataType:"json",
        		data:$("#writeFrm").serialize(),
        		success:function(data){  //list
        			
        		    alert(data.bno);
        		    alert(data.btitle);
        		    
        		    var dataHtml="";
        		    dataHtml += '<tr>';
    				dataHtml += '<td>'+data.bno+'</td>';
    				dataHtml += '<td class="table-title">'+data.btitle+'</td>';
    				dataHtml += '<td>'+data.id+'</td>';
    				dataHtml += '<td>'+data.bdate+'</td>';
    				dataHtml += '<td>'+data.bhit+'</td>';
    				dataHtml += '</tr>';
        		    
    				$("#tbody").append(dataHtml);
    				$("#id").val("");
    				$("#btitle").val("");
    				$("#bcontent").val("");
    				alert("게시글이 저장되었습니다.");
        		    
        		},
        		error:function(){
        			alert("실패");
        		}
        	});//ajax
    	});//click
    	
    	
    	
    });//function
    
    function listBtn(){
    	alert("테스트");
    	$.ajax({
    		url:"/board/boardList_ajax",
    		type:"post",
    		dataType:"json",
    		data:{},
    		success:function(data){  //list
    			alert("데이터를 가져옵니다.");
    			var dataHtml ="";
    			for(var i=0;i<data.length;i++){
    				dataHtml += '<tr>';
    				dataHtml += '<td>'+data[i].bno+'</td>';
    				dataHtml += '<td class="table-title">'+data[i].btitle+'</td>';
    				dataHtml += '<td>'+data[i].id+'</td>';
    				dataHtml += '<td>'+data[i].bdate+'</td>';
    				dataHtml += '<td>'+data[i].bhit+'</td>';
    				dataHtml += '</tr>';
    			}
    			
    			$("#tbody").html(dataHtml);
    			
    		},
    		error:function(){
    			alert("실패");
    		}
    	});
    }//function
  </script>
</head>
<body>
  <header>
    <ul>
      <li>회원가입</li> <span>|</span>
      <li>로그인</li> <span>|</span>
      <li>고객행복센터</li> <span>|</span>
      <li>배송지역검색</li> <span>|</span>
      <li>기프트카드 등록</li>
    </ul>
  </header>

  <nav>
    <div class="logo"></div>

    <div id="search">
      <div class="search"></div><br>
      <span>메뉴찾기</span>
    </div>

    <div id="cart">
      <div class="cart"></div><br>
      <span>장바구니</span>
    </div>

    <div class="nav-menu">
      <ul>
        <li>COOKIT소개</li>
        <li>COOKIT 메뉴</li>
        <li>리뷰</li>
        <li>이벤트</li>
        <li>MY쿡킷</li>
      </ul>  
    </div>
  </nav>

  <section>
    <h1>NOTICE</h1>
    <div class="wrapper">
      <form action="/search" name="search" method="post">
        <select name="category" id="category">
          <option value="0">전체</option>
          <option value="title">제목</option>
          <option value="content">내용</option>
        </select>

        <div class="title">
          <input type="text" size="16">
        </div>
  
        <button type="submit"><i class="fas fa-search"></i></button>
      </form>
    </div>

    <table>
      <colgroup>
	     <col width="8%">
	     <col width="49%">
	     <col width="13%">
	     <col width="20%">
	     <col width="10%">
	  </colgroup>
	   <tr>
		 <th>번호</th>
		 <th>제목</th>
		 <th>작성자</th>
		 <th>날짜</th>
		 <th>조회수</th>
	  </tr>
	  <tbody id="tbody">
	      <tr>
	        <td>1</td>
	        <td class="table-title">제목입니다.</td>
	        <td>aaa</td>
	        <td>2023-03-30</td>
	        <td>1</td>
	      </tr>
	  </tbody>
	  
    </table>

    <ul class="page-num">
      <li class="first"></li>
      <li class="prev"></li>
      <li class="num">
        <div>1</div>
      </li>
      <li class="next"></li>
      <li class="last"></li>
    </ul>
    <hr>
    <form action="/board/boardWrite" name="write" id="writeFrm" method="post">
      <table>
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" style="border:1px solid black;" id="id" name="id">
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" style="border:1px solid black;" id="btitle" name="btitle">
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea id="bcontent" name="bcontent" cols="50" rows="10"></textarea>
          </td>
        </tr>
        <tr>
          <th>이미지 표시</th>
          <td>
            <input type="file" name="file" id="file">
          </td>
        </tr>
      </table>
    </form>

    <div class="write" id="writeBtn" >쓰기</div>
  </section>
  

  <footer>
    <div class="wrapper">
      <div class="footer-left">
        <div class="footer-logo"></div>
        <div class="copyright">© COOKIT ALL RIGHTS RESERVED</div>
      </div>
  
      <div class="footer-center">
        <ul class="footer-nav">
          <li class="first-list">이용약관</li>
          <li class="green">개인정보처리 방침</li>
          <li>법적고지</li>
          <li>사업자정보 확인</li>
        </ul>
  
        <ul class="footer-info">
          <li class="first-list">씨제이제일제당(주)</li>
          <li>대표이사 : 손경식,강신호,신현재</li>
          <li>사업자등록번호 : 104-86-09535</li>
          <li class="first-list">주소 : 서울 중구 동호로 330 CJ제일제당 센터 (우) 04560</li>
          <li>통신판매업신고 중구 제 07767호</li>
          <li class="first-list">개인정보보호책임자 : 조영민</li>
          <li>이메일 : cjon@cj.net</li>
          <li>호스팅제공자 : CJ올리브네트웍스㈜</li>
        </ul>
  
        <div id="check">고객님은 안전거래를 위해 현금등으로 결제시 LG U+ 전자 결제의 매매보호(에스크로) 서비스를 이용하실 수 있습니다. <span class="check">가입 사실 확인</span></div>
      </div>
  
      <div class="footer-right">
        <div id="shortcut">
          <span>CJ그룹계열사 바로가기</span>
          <div class="shortcut"></div>
        </div>
  
        <div class="call">고객행복센터 1668-1920</div>
        <div class="inquery">1:1 문의</div>
      </div>
  
    </div>
  </footer>
</body>
</html>