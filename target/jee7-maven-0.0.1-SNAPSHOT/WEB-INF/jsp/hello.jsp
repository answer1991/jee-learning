<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${ student.name }</h2>
	
	<p>\${ student.name }</p>
	
	<P>${ true ? student.name : student.id }</P>
	
	<!-- 构建array -->
	<p>${ [1,3,5,2].stream().sorted().toList() }</p>
	
	<!-- lambda expression -->
	<p>${ ((a, b)-> a + b)(3, 4)}</p>
	
	<p>${ fun=(a, b)-> a * b}</p>
	<p>${ fun(3, 4) }</p>
</body>
</html>