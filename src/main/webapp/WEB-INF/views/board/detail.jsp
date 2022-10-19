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
	<h1>상세보기</h1>
	<div class="d-flex justify-content-center">
		<c:forEach items="${qnaVO}" var="qnaVO">
		<div><img src="C:/result/upload/qna/${qnaVO.qnaFileVOs.fileName}"/></div>
		</c:forEach>
	</div>
</body>
</html>