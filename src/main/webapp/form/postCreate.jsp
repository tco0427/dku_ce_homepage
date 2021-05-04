<%@ page import="dto.Classification" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>게시글 작성하기</title>
</head>
<body>
<c:set var="memberId" value="${sessionScope.id}"/>
<c:set var="id" value="${memberId}" scope="request"/>
<form action="/Post/PostCreate" method="post" accept-charset="UTF-8" style="margin:40px;">
    <div>
        <input name="id" type="text" value="${id}" style="display: none; visibility: hidden;">
    </div>
    <div class="mb-3">
        <label class="form-label">글 제목</label>
        <input name="title" type="text" maxlength="20" class="form-control" required>
        <div id="titleHelp" class="form-text">글 제목은 필수 항목입니다.</div>
    </div>
    <div class="mb-3">
        <label class="form-label">글 내용</label>
        <input name="content" type="text" class="form-control" required>
        <div id="contentHelp" class="form-text">글 내용은 필수 항목 입니다.</div>
    </div>
    <div class="mb-3">
        <label class="form-label">분류</label>
        <select name="classification" class="form-select" aria-label="Default select example">
            <c:forEach var="classification" items="<%=Classification.values()%>">
                <option value="${classification.name()}">${classification.name()}</option>
            </c:forEach>
        </select>
        <div id="classificationHelp" class="form-text">분류는 필수 항목 입니다.</div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
