<%@page import="com.nexon.mh.dto.CharacterBasicInfo"%>
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
	<img alt="벨콘" src="${cp }/resources/mb.jpg">
	<c:if test="${not empty cbInfo}">
		<p>캐릭터 이름: ${cbInfo.chaName}</p>
    	<p>생성 날짜: ${cbInfo.chaDateCreate}</p>
    	<p>직업: ${cbInfo.chaClassName}</p>
    	<p>레벨: ${cbInfo.chaLevel}</p>
    	<p>카르제: ${cbInfo.chaCairdeName}</p>
    	<p>총 타이틀 수: ${cbInfo.chaTitleCount}</p>
    	<p>드레스 포인트: ${cbInfo.chaDressPoint}</p>
	</c:if>
	<hr>
	<a href="${cp}/nexon/mhCharacter">캐릭터 검색</a>
</body>
</html>