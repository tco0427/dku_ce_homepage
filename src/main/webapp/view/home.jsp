<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="dao.PostRepositoryImpl" %>

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
            <img src="/resource/img/bear.png" width="333px"><br>
            <div style="font-size:16px;">컴퓨터공학과 커뮤니티에 오신 것을 환영합니다:-)<br><p></p></div>
        </div>
        <div class="description">
           <p/>컴퓨터공학과는 컴퓨터공학의 지식을 로봇, 영상, 통신 등 다양한 IT 분야에 활용할 수 있는 능력을 갖춘 인재를 배출하여 사회에 기여함을 목표로 합니다.
           이를 위해 컴퓨터공학의 이론을 습득하고 실제 시스템을 구현할 수 있는 능력을 배양하며 로봇, 영상, 통신 등 활용 분야의 지식을 이해할 수 있는 교육 과정을 운영합니다.
        </div>

        <div class="notice">
            <div style="font-size: 20px;font-weight: 400;margin-top: 10px;">
               Latest Notice<br>
                <hr size="2" width="116px" color="black" align="left">
            </div>

            <div>
                <c:set var="post" value="${PostRepositoryImpl.getInstance().findRecentPost()}"/>

                <div class="postName" style="font-weight: bold;margin-bottom:5px;">${post.title}</div>
                <div class="user" style="float:left;">작성자 : ${post.memberID}</div>
                <div class="date" style="font-size:10px; margin-left:5px; margin-top:10px;">[${post.creationDate}]</div>
                
                <hr style="border: 1px dashed lightgrey;">
                <div class="content">
                    ${post.content}
                </div>
            </div>
        </div>
    </div>
</div>
<div class="text-center">
	<jsp:include page="/fragments/footer.jsp" />
	</div>
</body>
</html>
