<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	 <c:if test="${sessionId != null}">
	   <h2>${sessionId} 님 환영합니다.</h2>
	 </c:if>
	 <c:if test="${sessionId == null}">
	   <h2>로그인이 되지 않았습니다.</h2>
	 </c:if>
	 
	 <h2>로그인페이지</h2>
	 <h4><a href="/">메인페이지이동</a></h4>
	 
	
	</body>
</html>