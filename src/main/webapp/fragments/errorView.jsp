<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--해당 jsp페이지를 에러 페이지로 지정--%>
<%@ page isErrorPage="true"%>
<%--
    응답 상태 코드별로 에러 페이지를 WEB-INF디렉토리의 web.xml파일에 지정해두었다.
    예를 들어 사용자가 정상적이지 않은 쿼리스트링을 사용하여 접근하는 경우 및 DB가 정상적으로 동작하지 않는 경우(DB서버가 off상태)에 발생하는 에러 등을
    처리하기 위한 용도로 만들어 두었다.
--%>
<html>
<head>
    <title>에러 발생</title>
</head>
<body>
<jsp:include page="/fragments/header.jsp" />
<div style="text-align: center; margin-top:40px;">
    요청 페이지 처리 과정에서 에러가 발생하였습니다. <br>
    빠른 시간 내에 문제를 해결하도록 하겠습니다.
    이용에 불편을 드려 죄송합니다.<br>
</div>
<jsp:include page="/fragments/footer.jsp" />
</body>
</html>