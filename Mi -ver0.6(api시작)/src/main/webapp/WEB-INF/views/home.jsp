<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 0. 웹 애플리케이션의 루트 경로(컨텍스트 경로) 를 가져와서 링크에 다 연결해줘야 함     -->									
<!-- 1. 0을 위한 준비. jstl core 태그 선언     -->									
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>									
<!-- 2. 0을 위한 준비. el 태그로 가져올 수 있는데 이걸 더 짧게 찍기위해 변수 대입함.     -->									
<c:set var="cp" value="${pageContext.request.contextPath}" /><!-- el변수 cp에 경로저장 -->		
							
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${cp }/resources/common.css" >
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>


<!-- <a href="/test/getOnePlusTwo">1+2 확인하러가기</a><hr> -->
<!-- <a href="/test/updateVisitantCount">문제 1번 확인하러가기</a><hr> -->
<!-- <a href="/test/insertDoodle">문제 2번 확인하러가기</a><hr> -->
<!-- <a href="/test/delTest">문제 3번 확인하러가기</a><hr> -->
<a href="${cp}/guest/getList">[방명록]</a>
<!-- <a href="/guest/read?bno=1">방명록-read</a><hr> -->
<!-- <a href="/guest/del?bno=2">방명록-del</a><hr> -->
<!-- <a href="/guest/write">방명록-write</a><hr> -->
<!-- <a href="/guest/modify?bno=1">방명록-modify</a><hr> -->
<a href="${cp}/weather/w">[날씨]</a>

</body>
</html>
