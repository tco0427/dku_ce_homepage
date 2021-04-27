<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
<style>
    .container-1{
        width: 200px;
        height:25px;
        border: solid;
        border-radius: 20px;
        vertical-align: middle;
        white-space: nowrap;
        position: relative;
    }
    .container-1 input#text{
        width: 150px;
        height: 20px;
        background: #ffffff;
        border: none;
        font-size: 10pt;
        float: left;
        color: #63717f;
        padding-left: 20px;
        -webkit-border-radius: 5px;
        -moz-border-radius: 5px;
        border-radius: 20px;
    }
    .container-1 .icon{
        position: absolute;
        top: 50%;
        margin-left: 17px;
        margin-top: 17px;
        z-index: 1;
        color: #4f5b66;
    }
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="box">
  <div class="container-1">
      <form action="/index.jsp">
      <input type="text" id="text" placeholder="Search..." />
      <label for="mySubmit"><i class="fa fa-search"></i></label>
      <input id="mySubmit" type="submit" value="" style=" background-color: Transparent;
    background-repeat:no-repeat;
    border: none;">
    </form>
  </div>
</div>
</body>
</html>