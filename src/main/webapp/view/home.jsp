<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>단국대학교 컴퓨터공학과</title>
    <link rel="stylesheet" href="/resource/css/home.css">
    <style>
    </style>
</head>
<body>
<c:set var="loginFlag" value="${sessionScope.login}"/>
<c:set var="loginFail" value="${requestScope.loginFail}"/>
<c:set var="registerErrorCode" value="${requestScope.registerErrorCode}"/>

<c:choose>
    <c:when test="${registerErrorCode eq -1}">
        out.println("<script>alert('회원가입에 실패하였습니다!'); history.go(-1);</script>");
    </c:when>
    <c:when test="${registerErrorCode eq -10}">
        out.println("<script>alert('이미 존재하는 아이디입니다.'); history.go(-1);</script>
    </c:when>
    <c:when test="${loginFail eq true}">
        out.println("<script>alert('로그인에 실패하였습니다.'); window.location='/index.jsp';</script>");
    </c:when>
</c:choose>

<div class="all">
    <header>
        <jsp:include page="/fragments/header.jsp"/>
    </header>
    <div class="search">
        <jsp:include page="/form/search.jsp"/>
    </div>
    <div class="menu">
        <c:choose>
            <c:when test="${loginFlag eq null}">
                <jsp:include page="/form/login.jsp"/>
            </c:when>
            <c:when test="${loginFlag eq 'success'}">
                <jsp:include page="/fragments/userProfile.jsp"/>
            </c:when>
        </c:choose>
        <br>
        <jsp:include page="/fragments/menu.jsp"/>
    </div>
    <div class="main">

        <div class="title">
            단국대학교 SW융합대학 컴퓨터공학과<br>
            <hr size="2" width="330px" color="black" align="left">
            <img src="/resource/img/bear.png" width="300px" style="margin-left:17px;"><br>
            <div class="description">
                컴퓨터공학과는 2018년도부터 SW융합대학에 소속.<br>ICT관과 제 2공학관을 주로 이용한다.<br> 코딩이랑 이거저거 배운다. 환영한다.<br>
            </div>
        </div>

        <div class="notice">
            <div style="font-size: 20px;font-weight: 400;margin-top: 10px;">
                Notice<br>
                <hr size="2" width="60px" color="black" align="left">
            </div>
            <div class="description">공지사항</div>
            <div class="bar">
                &nbsp;&nbsp;제목&nbsp;&nbsp;작성자 작성날짜
            </div>
        </div>
    </div>
</div>
<div class="text-center">
    <jsp:include page="/fragments/footer.jsp"/>
</div>
</body>
</html>
