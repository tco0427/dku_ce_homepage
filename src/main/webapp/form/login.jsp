<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/resource/css/login.css">
	<meta charset="UTF-8">
</head>
<body>
	<div>
		<article id="loginSection">
			<div>
				<form name="login" method="post" action="/Member/MemberLogin">
					<input type="text" name="id" maxlength="12" class="loginForm">
					<br> 
					<input type="password" name="password" maxlength="15" class="loginForm"> 
					<br>
					<button type="submit" class="login">로그인</button>
				</form>
			</div>
			<div>
				<button type="button" onclick="location.href='/form/signUp.jsp'"
					class="signUp">회원가입</button>
			</div>
		</article>
	</div>
</body>
</html>