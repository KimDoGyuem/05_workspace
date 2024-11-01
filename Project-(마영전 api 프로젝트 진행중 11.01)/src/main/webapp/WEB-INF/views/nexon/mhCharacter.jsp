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
	<img alt="벨콘" src="${cp }/resources/mb.jpg">
	<form action="${cp }/nexon/mhCharacter" method="post">
		<input name="name" placeholder="닉네임을 입력하세요">
		<input type="submit" value="검색">
	</form>
	<hr>
	<%
	String ocid = "";
	Object o = request.getAttribute("ocid");
	if(o==null){
		ocid = "미입력 상태";	
	}else{
		ocid = (String)o;
	}
	%>
	닉네임 ocid 변환값 : <%=ocid %>
	<br>
	<br>
	<%
	String text;
	if(!ocid.equals("미입력 상태") && !ocid.equals("x")){
		text = "캐릭터를 찾았습니다";
	}else if(ocid.equals("x")){
		text = "캐릭터를 찾지 못하였습니다";
	}else{
		text = "캐릭터를 검색 해주세요";
	}
	%>
	<%=text %>
	<hr>
	<a href="${cp}/nexon/characterBasic?ocid=<%=ocid%>">캐릭터 정보 조회</a>
	<a href="${cp}/">홈으로</a>
</body>
</html>