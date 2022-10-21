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
	<h1>${qnaVO.title}</h1>
	<div class="d-flex justify-content-center">
		<c:forEach items="${qnaVO.qnaFileVOs}" var="qnaVO">
		<div><img src="/file/app/upload/${qnaVO.fileName}"/></div>
		<div><a href="/fileDown/app/upload?fileNum=2">Down</a></div>
		<div><a href="/fileDown/app/upload?fileNum=2">Down</a></div>
		</c:forEach>
	</div>
</body>
</html>