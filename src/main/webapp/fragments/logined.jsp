<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
* {
	font-family: "나눔고딕";
}
.box {
    width: 150px;
    height: 150px; 
    border-radius: 70%;
    overflow: hidden;
}
.profile {
    width: 100%;
    height: 100%;
    object-fit: cover;
}
.userName {
	width: 150px;
    height: 150px;
    float:right;
    background-color: transparent;
    display:table-cell;
    vertical-align:middle;
}
.write{
  width: 100%;
  height: 25px;
  border-radius: 5px;
  background-color: rgb(128,128,128);
  border: none;
  color : white;
  margin-top:20px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="box" style="background: #BDBDBD; float:left;">
    <img class="profile" src="../resource/img/header.png">
</div>
<div class="userName" style="display:table-cell;vertical-align:middle;">
<div style="margin-top:40%; text-align: center;">User Name</div>
</div>
<button class="write">카페 글쓰기</button>
</body>
</html>