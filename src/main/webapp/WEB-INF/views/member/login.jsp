<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>로그인</h3>
	<div>
		<h3 style="color: red">${param.error}</h3>
		<h3 style="color: red">${param.message}</h3>
		<h3 style="color: red">${requestScope.msg}</h3>
	</div>
	<form action="login" method="post">
		<label>ID</label>
		<input type="text" name="id" value="${cookie.userId.value}"/>
		<label>PW</label>
		<input type="password" name="pw"/>
		<input type="checkbox" name="rememberId">
		<label>아이디 기억하기</label>
		<button>Login</button>
	</form>
	<script type="text/javascript">
	history.replaceState({}, null, location.pathname)
	</script>
</body>
</html>