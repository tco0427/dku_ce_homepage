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
			<div class="main">
				<c:set var="post" value="${requestScope.post}"/>
				<c:set var="nickName" value="${Member.getNickName(post.memberID)}"/>

				<div class="postCategory"> | ${post.classification}</div>
				<div class="postName">${post.title}</div>
				<div class="userProfile">
    				<i class="fa fa-user fa-2x" aria-hidden="true"></i>
				</div>
				<div class="user">${nickName}</div>
				<div class="date">${post.creationDate}</div>
				<hr>
				<div class="content">
				${post.content}
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
				
				<form action="댓글작성액션" method="댓글메소드" accept-charset="UTF-8">
				
				<div class="">
					
					<textarea name="content" cols="75" rows="4" class="comment" placeholder="댓글을 입력해주세요" required></textarea>
					
					<button type="submit" class="submitBtn">등록</button>
					
				</div>
			</form>
				
			</div>
		</div>
	</div>
	<%-- <div class="text-center">
		<jsp:include page="/fragments/footer.jsp"/>
	</div> --%>
</body>
</html>
