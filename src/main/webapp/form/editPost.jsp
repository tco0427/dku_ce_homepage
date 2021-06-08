<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="dto.Post" %>

<html>
<head>
<title>게시글 수정하기</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="/resource/css/contentDetail.css">
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
				<c:set var="postId" value="${param.id}"/>
				<c:set var="post" value="${Post.getInstance(postId)}"/>
				<c:set var="nickName" value="${Member.getNickName()}"/>
				<form action="/Post/PostUpdate" method="post" accept-charset="UTF-8" >

					<div class="postCategory"> | ${post.classification}</div>
					<div class="postName">${post.title}</div>
					<div class="userProfile">
	    				<i class="fa fa-user fa-2x" aria-hidden="true"></i>
					</div>
					<div>
						<input name="postId" type="text" value="${post.id}"
							   style="display: none; visibility: hidden;">
					</div>
					<div class="user">${nickName}</div>
					<div class="date">${post.creationDate}</div>
					<hr>
					
					<div class="content">
						<textarea name="content" cols="40" rows="100" class="content" value="${post.content}" required>${post.content}</textarea>
						<div class="submit">
							<label for="fileUpload">
								<i class="fa fa-folder-o" style="margin-left: 10px; margin-top: 10px;" aria-hidden="true"></i>
							</label>
							파일을 새로 업로드하시겠어요?
							<input id="fileUpload" type="file" name="attachFile">
							<button type="submit" class="modifyBtn">수정</button>
						</div>
					</div>
				</form>
		</div>
	</div>
</div>
</body>
</html>
