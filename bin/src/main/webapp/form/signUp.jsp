<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dto.Member" %>
<html>
<head>
    <%--meta태그는 웹 서버와 웹 브라우저간에 상호 교환되는 정보를 정의하는데 사용한다.
        웹 페이지의 저작자, 문자 인코딩 방식 등 다양한 메타데이터를 표현한다.
        http-equiv속성은 content속성에 명시된 값에 대한 HTTP헤더를 제공한다.
        다음은 해당 문서의 인코딩 방식을 설정하고 있다.--%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--head영역에서 link와 script태그를 이용하여 외부 js파일과 css파일을 불러오고 있는데, 이는 부트스트랩을 이용하고 있기 때문이다.
        부트스트랩이란 프론트엔드 개발을 빠르고 쉽게 할 수 있는 프레임워크로 HTML과 CSS기반의 템플릿 양식, js를 선택적으로 확장할 수 있는 특징을 지닌다.--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
    <title>회원 가입</title>
</head>
<body>
<jsp:include page="/fragments/header.jsp" />

<form action="/controller/signUpController.jsp" method="post" accept-charset="UTF-8" style="margin:40px;">
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
        <select name="none" class="form-select" aria-label="Default select example">
            <option value="<%=Member.passwordHintQuestion.get(0)%>" selected><%=Member.passwordHintQuestion.get(0)%></option>
            <%
                for(int i=1;i<Member.passwordHintQuestion.size();i++){
            %>
            <option value="<%=Member.passwordHintQuestion.get(i)%>"><%=Member.passwordHintQuestion.get(i)%></option>
            <%
                }
            %>
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
