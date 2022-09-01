<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%
	request.setCharacterEncoding("utf-8");
%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인결과창</title>
</head>
<body>
	<h1>로그인 확인</h1>
	아이디 : ${userId} <br>
	이름 : ${userName}<br>
	<hr>
	아이디 : ${info.userId} <br>
	이름 : ${info.userName}<br>
	<hr>

</body>
</html>