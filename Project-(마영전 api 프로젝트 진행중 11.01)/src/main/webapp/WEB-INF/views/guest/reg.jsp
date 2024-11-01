<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${cp}/resources/common.css?ver=<%= System.currentTimeMillis() %>">
</head>
<body>
	<form action="${cp }/guest/reg" method="post">
		<input name="id" placeholder="아이디입력"><br>
		<input name="pw" placeholder="비번입력"><br>
		<input type="submit" value="회원가입"> 
	</form>
<%
Object o = request.getAttribute("regCount");
String r = "";
int regCount = 0;
if(o==null){
	r="";
}else{
	regCount = (int)o;
	if(regCount == 0){
		r="회원가입 성공";
	}else{
		r="회원가입 실패";
	}
}
%>	
<%=r %>
<br>
<a href="${cp }/">홈으로</a>

</body>
</html>