<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.login{
  width: 100%;
  height: 25px;
  border-radius: 5px;
  background-color: rgb(128,128,128);
  border: none;
  color : white;
}
.loginForm{
  width: 100%;
}
.signUp{
  
  height: 20px;
  border: none;
  color : black;
  background-color: transparent;
  border: 0;
  outline: 0;
  float:right;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="width: 80%">
<article id="loginSection">
            <div class="loginForm">
                <form name="login" method="post" action="/controller/loginController.jsp">
                    <input type="text" name="id" maxlength="12" class="loginForm">
                    <br>
                    <input type="password" name="password" maxlength="15" class="loginForm">
                    <br>
                    <button type="submit" class="login">로그인</button>
                </form>
            </div>
            <div>
            <button type="button" onclick="location.href='/form/signUp.jsp'" class="signUp">회원가입</button>
            </div>
        </article>
</div>
</body>
</html>