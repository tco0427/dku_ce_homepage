<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="dto.Member" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
    <title>회원 가입</title>
</head>
<body>
<jsp:include page="/fragments/header.jsp" />

<form action="/Member/MemberJoin" method="post" accept-charset="UTF-8" style="margin:40px;">
    <div class="mb-3">
        <label class="form-label">아이디</label>
        <input name="id" type="text" maxlength="12" class="form-control" required>
        <div id="id" class="form-text">아이디는 필수 항목입니다.</div>
    </div>
    <div class="mb-3">
        <label class="form-label">비밀번호</label>
        <input name="password" type="password" maxlength="15" class="form-control" required>
        <div id="password" class="form-text">비밀 번호는 필수 항목 입니다.</div>
    </div>
    <div class="mb-3">
        <label class="form-label">비밀번호 확인</label>
        <input name="passwordCheck" type="password" class="form-control" required>
        <div id="passwordCheck" class="form-text">비밀 번호는 필수 항목 입니다.</div>
    </div>
    <div class="mb-3">
        <label class="form-label">비밀번호 찾기 질문</label>
        <select name="passwordHintQuestion" class="form-select" aria-label="Default select example">
            <c:forEach var="passwordHintQuestion" items="<%=Member.passwordHintQuestion%>">
                <option value="${passwordHintQuestion}">${passwordHintQuestion}</option>
            </c:forEach>
        </select>
        <input name="passwordHint" type="text" maxlength="20" class="form-control" required>
        <div id="passwordHint" class="form-text">비밀번호 힌트는 필수 항목 입니다.</div>
    </div>
    <div class="mb-3">
        <label class="form-label">학번</label>
        <input name="studentID" type="number" maxlength="8" class="form-control" required>
        <div id="studentID" class="form-text">학번은 필수 항목 입니다.</div>
    </div>
    <div class="mb-3">
        <label class="form-label">이름</label>
        <input name="name" type="text" maxlength="10" class="form-control" required>
        <div id="name" class="form-text">이름은 필수 항목 입니다.</div>
    </div>
    <div class="mb-3">
        <label class="form-label">이메일</label>
        <input name="email" type="text" maxlength="30" class="form-control" required>
        <div id="email" class="form-text">이메일은 필수 항목 입니다.</div>
    </div>
    <div class="mb-3">
        <label class="form-label">닉네임</label>
        <input name="nickname" type="text" maxlength="10" class="form-control">
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="/fragments/footer.jsp" />
</body>
</html>
