<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./join" method="POST">
		<h3>회원가입</h3>
		<label>ID</label>
		<input type="text" name="id"/>
		<label>PW</label>
		<input type="password" name="pw"/>
		<label>NAME</label>
		<input type="text" name="name"/>
		<label>EMAIL</label>
		<input type="text" name="email"/>
		<button>가입하기</button>
	</form>
</body>
</html>