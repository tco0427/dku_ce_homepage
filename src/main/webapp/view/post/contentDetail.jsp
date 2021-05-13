<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="dto.Member" %>

<html>
<head>
<title>자세히보기</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="/resource/css/contentDetail.css">
</head>

<body>
	<c:set var="loginFlag" value="${sessionScope.login}" />
	<c:set var="loginFail" value="${requestScope.loginFail}" />
	<c:set var="registerErrorCode" value="${requestScope.registerErrorCode}" />
	<c:set var="postList" value="${requestScope.postList}"/>

	<c:choose>
		<c:when test="${registerErrorCode eq -1}">
        	out.println("<script>alert('회원가입에 실패하였습니다.'); history.go(-1);</script>");
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
			<div class="main">
				<div class="postCategory"> | Notice</div>
				<div class="postName">게시글 제목</div>
				<div class="userProfile">
    				<i class="fa fa-user fa-2x" aria-hidden="true"></i>
				</div>
				<div class="user">사용자이름</div>
				<div class="date">2021.05.11</div>
				<hr>
				<div class="content">
				게시글 내용 - 여러분 오늘은 무엇을 할 계획인가요~~? 전 p형이라 계획같은 건 안세운답니다~~ㅎ
				</div>
				<div class="like">
					<i class="fa fa-heart-o" aria-hidden="true"></i> 좋아요 10개
				</div>
				<div class="comment-icon">
					<i class="fa fa-comment-o" aria-hidden="true"></i> 댓글 2개
				</div>
				<hr>
				<div class="comment-title">댓글</div>
				
				<div class="userProfile">
    				<i class="fa fa-user fa-2x" aria-hidden="true"></i>
				</div>
				<div class="user-comment">사용자이름</div>
				<div class="comment">댓글 내용</div>
				<div class="date-comment">2021.05.11</div>
				<hr style="border: 1px dashed lightgrey;">
				
				<div class="userProfile">
    				<i class="fa fa-user fa-2x" aria-hidden="true"></i>
				</div>
				<div class="user-comment">박진아</div>
				<div class="comment">드라이브 슝슝가고싶당</div>
				<div class="date-comment">2021.05.11</div>
				<hr style="border: 1px dashed lightgrey;">
				
				
			</div>
		</div>
	</div>
	<div class="text-center">
		<jsp:include page="/fragments/footer.jsp"/>
	</div>
</body>
</html>
