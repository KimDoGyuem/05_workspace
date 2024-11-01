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
	<form action="${cp }/guest/write" method="post">
		<textarea rows="3" name="btext"></textarea>
		<input type="submit" value="글쓰기">
	</form>
</body>
</html>