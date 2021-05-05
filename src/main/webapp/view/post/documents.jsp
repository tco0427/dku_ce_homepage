<%--
  Created by IntelliJ IDEA.
  User: dongkyu
  Date: 2021/05/04
  Time: 8:40 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="btn-toolbar mb-3 " role="toolbar" aria-label="Toolbar with button groups">
    <div class="btn-group me-2" role="group" aria-label="First group">
        <button type="button" class="btn btn-outline-secondary" onclick="location='/Classification/Notice?page=${param.page-1}'">이전</button>
        <c:forEach var="i" begin="${requestScope.blockNum}" end="${requestScope.blockNum+9}">
            <button type="button" class="btn btn-outline-secondary" onclick="location='/Classification/Notice?page=${i}'">${i}</button>
        </c:forEach>
        <button type="button" class="btn btn-outline-secondary" onclick="location='/Classification/Notice?page=${param.page+1}'">다음</button>
    </div>
</div>
</body>
</html>
