<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="dto.Member" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="/resource/css/signUp.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
    <title>회원 정보 수</title>
</head>
<body>

<div class="sign">
<jsp:include page="/fragments/header.jsp" />
<c:set var="name" value="${sessionScope.id}"/>
<c:set var="name" value="${sessionScope.password}"/>
<c:set var="name" value="${sessionScope.email}"/>
<c:set var="name" value="${sessionScope.nickName}"/>
<!-- 한 번 해봤는데 id밖에 안불러와지넹 ㅎㅎ -->
<form action="/Member/MemberJoin" method="post" accept-charset="UTF-8" style="margin:40px;">
    <div class="mb-3">
        <label class="form-label">아이디</label>
        <input name="id" type="text" maxlength="12" class="form-control" value="${id}" required>
    </div>
    <div class="mb-3">
        <label class="form-label">비밀번호</label>
        <input name="password" type="password" maxlength="15" class="form-control" value="${password}" required>
    </div>
    <div class="mb-3">
        <label class="form-label">비밀번호 확인</label>
        <input name="passwordCheck" type="password" class="form-control" required>
        <div id="passwordCheck" class="form-text">비밀 번호는 필수 항목 입니다.</div>
    </div>
    
    <div class="mb-3">
        <label class="form-label">이메일</label>
        <input name="email" type="text" maxlength="30" class="form-control" value="${email}" required>
    </div>
    <div class="mb-3">
        <label class="form-label">닉네임</label>
        <input name="nickname" type="text" maxlength="10" class="form-control" value="${nickName}">
    </div>

    <button type="submit" class="button">수정완료</button>
</form>
</div>
<jsp:include page="/fragments/footer.jsp" />
</body>
</html>
