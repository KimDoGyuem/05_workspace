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
	<img alt="벨짱" src="${cp }/resources/mbmb.jpg">
	<form action="${cp}/nexon/mhRanking" method="post">
		<select name="type">
			<option value="0">물리 공격력 순위</option>		
			<option value="1">마법 공격력 순위</option>		
		</select>
		<input type="submit" value="랭킹 조회">
	</form>
	<hr>
	
	<c:if test="${not empty mrInfo}">
		<table>
			<tr>
				<td>랭킹 순위</td>	
				<td>캐릭터 이름</td>	
				<td>랭킹 점수</td>	
			</tr>
			
			<c:forEach var="i" begin="0" end="${mrInfo.mhRanking.size()-1}">
			<tr>
				<td>${mrInfo.mhRanking.get(i).ranking }</td>		
				<td><a href="${cp}/nexon/rankingCharacter?name=${mrInfo.mhRanking.get(i).name}">${mrInfo.mhRanking.get(i).name}</a></td>		
				<td>${mrInfo.mhRanking.get(i).score }</td>		
			</tr>
			</c:forEach>
		</table>
	</c:if>
	<a href="${cp}/">홈으로</a>
</body>
</html>