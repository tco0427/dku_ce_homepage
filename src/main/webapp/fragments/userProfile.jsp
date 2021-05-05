<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/resource/css/userProfile.css">
    <meta charset="UTF-8">
</head>
<body>
<c:set var="name" value="${sessionScope.name}"/>
<div class="box">
    <i class="fa fa-user fa-5x" aria-hidden="true"></i>
</div>
<div class="userName">
    ${name}
</div>
<button class="logout" onclick="location.href='/Member/MemberLogout'">로그아웃</button>
<button class="write" onclick="location.href='/Post'">카페 글쓰기</button>
</body>
</html>