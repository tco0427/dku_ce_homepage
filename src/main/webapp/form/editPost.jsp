<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="dto.Member" %>

<html>
<head>
<title>게시글 수정하기</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="/resource/css/contentDetail.css">
	<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script> -->

<style>
.modifyBtn{
	width:70px;
	height:38px;
	background-color:#F2F1F1;
	border: none;
	border-radius:5px;
	font-size:15;
	float:right;
	margin-right:5px;
}
.btn-area {
	width:700px;
	height:40px;
	background-color:#F2F1F1;
}
</style>
</head>

<body>
	<c:set var="loginFlag" value="${sessionScope.login}" />
	<c:set var="loginFail" value="${requestScope.loginFail}" />
	<c:set var="postList" value="${requestScope.post}"/>

	<c:choose>
		<c:when test="${loginFail eq true}">
        	out.println("<script>alert('로그인에 실패하였습니다.'); window.location='/index.jsp';</script>");
    	</c:when>
	</c:choose>

	<div class="all">
		<header>
			<jsp:include page="/fragments/header.jsp" />
		</header>
		<div class="search">
			<jsp:include page="/form/search.jsp" />
		</div>
		<div class="menu">
			<c:choose>
				<c:when test="${loginFlag eq null}">
					<jsp:include page="/form/login.jsp" />
				</c:when>
				<c:when test="${loginFlag eq 'success'}">
					<jsp:include page="/fragments/userProfile.jsp" />
				</c:when>
			</c:choose>
			<br>
			<jsp:include page="/fragments/menu.jsp" />
		</div>
		<div>
			<div class="main" style="height: auto;">
				<c:set var="post" value="${requestScope.post}"/>
				<c:set var="nickName" value="${Member.getNickName(post.memberID)}"/>
				<form>
					<div class="postCategory"> | 카테고리</div>
					<div class="postName">게시글제목</div>
					<div class="userProfile">
	    				<i class="fa fa-user fa-2x" aria-hidden="true"></i>
					</div>
					
					<div class="user">닉네임</div>
					<div class="date">2021.05.31</div>
					
					<hr>
				
					<div class="content">
					<textarea name="content" cols="40" rows="100" class="content" placeholder="기존내용불러오기" required></textarea>
					</div>
					<div class="btn-area">
					<button type="submit" class="modifyBtn">수정완료</button>
					</div>
				</form>
				<div class="like">
					<c:choose>
						<c:when test="${post.attachFile ne null}">
							<a href="" download="${post.attachFile}">다운로드</a>
						</c:when>
					</c:choose>
				</div>
				
		</div>
	</div>
</div>
	<%-- <div class="text-center">
		<jsp:include page="/fragments/footer.jsp"/>
	</div> --%>
</body>
</html>