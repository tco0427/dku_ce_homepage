<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<%--
<sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/ceHomepage?useSSL=false&allowPublicKeyRetrieval=true"
    user="root" password="admin"/>

<sql:query var="rs" sql="select * from post where classification='Notice' order by creationDate desc limit 1" dataSource="${ds}"/>
<div>
    <c:out value="${rs.title}"/>
</div>
--%>
</body>
</html>
