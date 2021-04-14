<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>단국대학교 컴퓨터공학과</title>
</head>
<body>
    <header>
        <%@ include file="/fragments/header.jsp" %>
    </header>
    <section>
        <article id="loginSection">
            <div id="login">
                <form name="login" method="post" action="/controller/loginController.jsp">
                    <input type="text" name="id" maxlength="12">
                    <br>
                    <input type="password" name="password" maxlength="15">
                    <br>
                    <button type="submit">로그인</button>
                    <button type="button" onclick="location.href='/form/signUp.jsp'">회원가입</button>
                </form>
            </div>
        </article>
    </section>
</body>
</html>