<%@page import="com.project.dto.AccountDto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath }" />
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="${cp }/resources/common.css" >
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<a href="${cp }/guest/getList">방명록</a>
	<a href="${cp }/guest/reg">회원가입</a>
	<a href="${cp }/guest/log">로그인</a>
	<a href="${cp }/guest/logOut">로그아웃</a>
	<br>
	<hr>
	<%
	Object o = session.getAttribute("log");
	AccountDto log = (AccountDto) o;
	String logtext = "";
	if (o == null) {
		logtext = "";
	} else {
		logtext = "반갑습니다" + log.getId() + "님";
	}
	%>
	<%=logtext%>
	<hr>
	api테스트<br>
	<a href="${cp }/nexon/mhCharacter">캐릭터 검색</a>
</body>
</html>
