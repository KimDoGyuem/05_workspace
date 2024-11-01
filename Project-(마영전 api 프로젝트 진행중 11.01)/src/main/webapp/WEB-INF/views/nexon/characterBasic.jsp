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
<link rel="stylesheet"
	href="${cp}/resources/common.css?ver=<%= System.currentTimeMillis() %>">
</head>
<body>
	<img alt="벨콘" src="${cp }/resources/mb.jpg">
	<div id="box">
		<div id="cb">
			<c:if test="${not empty cbInfo}">
				<p>캐릭터 이름: ${cbInfo.chaName}</p>
				<p>생성 날짜: ${cbInfo.chaDateCreate}</p>
				<p>직업: ${cbInfo.chaClassName}</p>
				<p>레벨: ${cbInfo.chaLevel}</p>
				<p>카르제: ${cbInfo.chaCairdeName}</p>
				<p>총 타이틀 수: ${cbInfo.chaTitleCount}</p>
				<p>드레스 포인트: ${cbInfo.chaDressPoint}</p>
				<p>길드: ${cgInfo.guildName}</p>
			</c:if>
		</div>
		<div id="cs">
			<c:if test="${not empty csInfo }">
				<p>공격력: ${csInfo.offensive_power}</p>
				<p>마법공격력: ${csInfo.magic_power}</p>
				<p>방어력: ${csInfo.defensive_power}</p>
				<p>행운: ${csInfo.luck}</p>
				<p>최대 생명력: ${csInfo.max_hp}</p>
				<p>최대 스테미나: ${csInfo.stamina}</p>
				<p>공격속도: ${csInfo.attack_speed}</p>
				<p>추가피해: ${csInfo.additional_damage}</p>
				<p>크리티컬: ${csInfo.critical}</p>
				<p>크리티컬 피해량: ${csInfo.critical_Damage}</p>
				<p>크리티컬 저항: ${csInfo.critical_Resistance}</p>
				<p>밸런스: ${csInfo.balance}</p>
				<p>공격력 제한 해제: ${csInfo.unrestricting_Attacks}</p>
				<p>대항력: ${csInfo.opposing_power}</p>
			</c:if>
		</div>
	</div>
	<hr>
	<a href="${cp}/nexon/mhCharacter">캐릭터 검색</a>
	<a href="${cp}/">홈으로</a>
</body>
</html>