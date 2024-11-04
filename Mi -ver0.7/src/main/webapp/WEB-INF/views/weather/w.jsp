<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${cp }/resources/common.css" >
</head>
<body>
<%
	Object a = (String)request.getAttribute("date");
	Object b = (String)request.getAttribute("weathertext");
	
	String x = (String)a;
	String y = (String)b;
%>	
<%=x %><br>
<%=y %>
</body>
</html>