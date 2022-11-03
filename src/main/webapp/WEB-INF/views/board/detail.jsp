<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="../temp/boot.jsp"></c:import>
	<h1>${qnaVO.title}</h1>
	<div class="justify-content-center">
		<c:forEach items="${qnaVO.qnaFileVOs}" var="qnaFileVO">
		<div><img src="/file/qna/${qnaFileVO.fileName}"/></div>
		<div><a href="/fileDown/qna?fileNum=${qnaFileVO.fileNum}">${qnaFileVO.oriName}</a></div>
		</c:forEach>
	</div>
	<div class="mt-2">
		<a href="./update?num=${qnaVO.num}" class="btn btn-outline-info">글수정하기</a>
	</div>
</body>
</html>