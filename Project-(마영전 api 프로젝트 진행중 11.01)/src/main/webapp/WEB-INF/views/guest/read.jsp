<%@page import="com.project.dto.GuestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${cp}/resources/common.css?ver=<%= System.currentTimeMillis() %>">
</head>
<body>
<%
	GuestDto read = (GuestDto)request.getAttribute("read");
	long bno = read.getBno();
	String btext = read.getBtext();
%>

글본문<br>
글번호:<%=bno %><br>
글내용:<%=btext %><br>
<a href="${cp }/guest/del?bno=<%=bno%>">글삭제</a>
<a href="${cp }/guest/modify?bno=<%=bno%>">글수정</a>
<a href="${cp }/guest/getList">글리스트</a>
</body>
</html>