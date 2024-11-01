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
<h1>방명록</h1>
<h2>글목록</h2>
<table>
	<tr>
		<td>번호</td>
		<td>내용</td>
	</tr>
<c:set var="list" value="${blp.posts }"/>	
<c:forEach var="i" items="${list }">
<tr>
<td>${i.bno}</td>
<td><a href="${cp }/guest/read?bno=${i.bno}">${i.btext}</a></td>
</tr>
</c:forEach>	
</table>	

<c:if test="${blp.hasPrev}">
	<a href="${cp}/guest/getList?word=${blp.word }&currentPage=${blp.prevPage}">이전</a>
</c:if>

<c:forEach var="i" begin="${blp.blockStartNo }" end="${blp.blockEndNo}">
	<a href="${cp }/guest/getList?word=${blp.word }&currentPage=${i}">${i }</a>
</c:forEach>

<c:if test="${blp.hasNext }">
	<a href="${cp }/guest/getList?word=${blp.word }&currentPage=${blp.nextPage}">다음</a>
</c:if>

<br>
검색어=${blp.word}

<form action="${cp }/guest/getList" method="get">
	<input name="word" placeholder="검색어 입력">
	<input type="submit" value="검색">
</form>


<a href="${cp }/guest/write">글쓰기</a>
<a href="${cp }/">홈으로</a>
</body>
</html>