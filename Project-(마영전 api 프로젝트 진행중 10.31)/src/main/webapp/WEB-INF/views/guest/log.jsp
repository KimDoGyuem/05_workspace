<%@page import="com.project.dto.AccountDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${cp }/resources/common.css" >
</head>
<body>
	<form action="${cp }/guest/log" method="post">
		<input name="id" placeholder="아이디입력"><br>
		<input name="pw" placeholder="비번입력"><br>
		<input type="submit" value="로그인">
	</form>
<%
Object x = request.getAttribute("notLog");
Object o = session.getAttribute("log");
String notLog = (String)x;
String logtext = "";
if(notLog.equals("x")&&o==null){
	logtext = "비로그인 상태입니다";
}else{
	if(o==null){
		logtext = "로그인 정보가 틀렸습니다";
	}else{
		AccountDto log = (AccountDto)o;
		logtext = log.getId()+"으로 로그인 중입니다";
	}
}
%>	
<%=logtext %>
<br>
<a href="${cp }/">홈으로</a>
</body>
</html>