<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<style type="text/css">
	a:hover{
		font-weight: bold;
		font-size: 17px;
	}
</style>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<h1 style="margin: 50px auto; text-align: center; font-family: cursive;">List</h1>
	<table class="table table-dark table-striped" style="width:80%; margin:0 auto;">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="qnaVO">
			<tr>
				<td>${qnaVO.num}</td>
				<td><a href="./detail?num=${qnaVO.num}" style="color:white; text-decoration: none;">${qnaVO.title}</a></td>
				<td>${qnaVO.contents}</td>
				<td>${qnaVO.writer}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="d-flex justify-content-between" style="width: 80%; margin: 10px auto;">
		<a href="../" style="text-decoration: none;" class="btn btn-danger">👈뒤로가기</a>
		<div>
			<a href="./add" class="btn btn-primary">글작성</a>
		</div>
	</div>
	
	<script type="text/javascript">
		let result = '${param.result}';
		if(result != ""){
			if(result == '1'){
/* 				alert("등록성공"); */
			}else{
				alert("등록실패");
			}
		}
	</script>
</body>
</html>