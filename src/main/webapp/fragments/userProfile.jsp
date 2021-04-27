<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/resource/css/userProfile.css">
    <meta charset="UTF-8">
</head>
<body>
<c:set var="name" value="${sessionScope.name}"/>
<div class="box" style="background: #BDBDBD; float:left;">
    <img class="profile" src="">
</div>
<div class="userName" style="display:table-cell; vertical-align:middle;">
    <div style="margin-top:40%; text-align: center;">${name}</div>
</div>
<button class="write">카페 글쓰기</button>
</body>
</html>