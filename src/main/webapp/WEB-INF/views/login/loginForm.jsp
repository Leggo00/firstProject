<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<c:set var="contextPath" value="${pageContext.request.contextPath }" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인폼</title>
</head>
<body>
	<h1>로그인 폼 </h1>
	${test}
	<form action="${contextPath}/login/login4" method="post">
		아이디 : <input type="text" name="userId"><br>		
		이름 : <input type="text" name="userName"><br>		
		<input type="submit" value="보내기">	
	</form>
</body>
</html>