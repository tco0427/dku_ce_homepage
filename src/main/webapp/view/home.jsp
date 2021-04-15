<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>단국대학교 컴퓨터공학과</title>
<style>
.all {
	width: 1000px;
	margin: 0px auto;
	font-family: "나눔고딕";
}

.menu {
	width: 200px;
	height: 100%;
	border-top: 5px solid rgb(128, 128, 128);
	margin-top: 52px;
	padding: 20px;
	float: left;
}

.main {
	width: 700px;
	height: 1000px;
	border: 5px solid lightgrey;
	padding: 20px;
	margin-top: 10px;
	float: right;
}

.search {
	float: right;
	margin-top: 10px;
}

.bar {
	border-top: 3px solid rgb(128,128,128);
	border-bottom: 2px solid lightgrey;
	margin-top:20px;
	word-spacing:100px;
}
.title {
	font-size: 20px;
	font-weight: 400;
	margin-top: 10px;
	margin-left:190px;
}
.description {
	font-size: 15px;
}
</style>
</head>
<body>
	<div class="all">
		<header>
			<%@ include file="/fragments/header.jsp"%>
		</header>
		<div class="search">
			<%@ include file="/form/search.jsp"%>
		</div>
		<div class="menu">
			<%@ include file="/form/login.jsp"%>
			<br>
			<%@ include file="/fragments/menu.jsp"%>
		</div>
		<div class="main">

			<div class="title">
				단국대학교 SW융합대학 컴퓨터공학과<br>
				<hr size="2" width="330px" color="black" align="left">
				<img src="/resource/img/bear.png" width="300px" style="margin-left:17px;"><br>
				<div class="description">
					컴퓨터공학과는 2018년도부터 SW융합대학에 소속.<br>ICT관과 제 2공학관을 주로 이용한다.<br> 코딩이랑 이거저거 배운다. 환영한다.<br>
				</div>
			</div>

			<div class="notice">
				<div style="font-size: 20px;font-weight: 400;margin-top: 10px;">
					Notice<br>
					<hr size="2" width="60px" color="black" align="left">
				</div>
				<div class="description">공지사항</div>
				<div class="bar">
					&nbsp;&nbsp;제목&nbsp;&nbsp;작성자 작성날짜
				</div>
			</div>
		</div>
	</div>
</body>
</html>