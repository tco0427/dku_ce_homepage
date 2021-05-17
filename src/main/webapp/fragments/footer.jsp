<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <%--head영역에서 link와 script태그를 이용하여 외부 js파일과 css파일을 불러오고 있는데, 이는 부트스트랩을 이용하고 있기 때문이다.
        부트스트랩이란 프론트엔드 개발을 빠르고 쉽게 할 수 있는 프레임워크로 HTML과 CSS기반의 템플릿 양식, js를 선택적으로 확장할 수 있는 특징을 지닌다.--%>
    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script> -->
<style>
.text-center {
	font-family: "나눔고딕";
}
</style>
</head>
<body>
<%--"text-center"는 부트스트랩에서 제공하는 기능으로 해당 class를 지정하여주면 text를 가운데 정렬해준다.--%>
 <div class="text-center">
    <%--footer부분은 간단하게 hr태그를 통해 구분선을 그어주고, 웹 페이지 제작자에 대한 간단한 정보와 문의를 위한 메일 정보를 제공하고 있다.--%>
    <hr>
    <p>
        &copy; 단국대학교 컴퓨터공학과
        <br>
        과사 문의: 031-8005-3653
    </p>
</div></body>
</html>