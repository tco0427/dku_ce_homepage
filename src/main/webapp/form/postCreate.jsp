<%@ page import="dto.Classification"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/resource/css/postCreate.css">
<title>게시글 작성하기</title>
</head>
<body>
	<c:set var="loginFlag" value="${sessionScope.login}" />
	<c:set var="loginFail" value="${requestScope.loginFail}" />
	<c:set var="registerErrorCode"
		value="${requestScope.registerErrorCode}" />

	<c:choose>
		<c:when test="${registerErrorCode eq -1}">
        out.println("<script>
									alert('회원가입에 실패하였습니다!');
									history.go(-1);
								</script>");
    </c:when>
		<c:when test="${registerErrorCode eq -10}">
        out.println("<script>
									alert('이미 존재하는 아이디입니다.');
									history.go(-1);
								</script>
		</c:when>
		<c:when test="${loginFail eq true}">
        out.println("<script>
									alert('로그인에 실패하였습니다.');
									window.location = '/index.jsp';
								</script>");
    </c:when>
	</c:choose>
	<c:set var="memberId" value="${sessionScope.id}" />
	<c:set var="id" value="${memberId}" scope="request" />
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
		<div class="main">
			<form action="/Post/PostCreate" method="post" accept-charset="UTF-8"
				style="margin: 15px;">
				<div>
					<input name="id" type="text" value="${id}"
						style="display: none; visibility: hidden;">
				</div>
				<div class="description">
					카페 글쓰기<br>
					<hr size="2" width="100px" color="black" align="left">
				</div>
				<div class="mb-1">
					<input name="title" type="text" maxlength="20" class="title"
						placeholder="제목을 입력해주세요" required>
				</div>
				<div class="mb-2">
					<select name="classification" class="select"
						aria-label="Default select example">
						<c:forEach var="classification"
							items="<%=Classification.values()%>">
							<option value="${classification.name()}">${classification.name()}</option>
						</c:forEach>
					</select>
				</div>
				<div class="mb-3">
					<div class="submit">
						<i class="fa fa-picture-o"
							style="margin-left: 10px; margin-top: 10px;" aria-hidden="true"></i>
						<i class="fa fa-folder-o"
							style="margin-left: 10px; margin-top: 10px;" aria-hidden="true"></i>
						<button type="submit" class="submitBtn">등록</button>
					</div>
					<textarea name="content" cols="40" rows="100" class="content" placeholder="내용을 입력해주세요" required></textarea>
				</div>


			</form>
		</div>
	</div>

</body>
</html>
