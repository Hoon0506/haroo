<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a{
		text-decoration: none;
	}
</style>
</head>
<body>
	<h2>글세부보기</h2>
	<table border="1">
		<tr>
			<td>제목</td>
			<td>${board.title }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${board.writer }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${board.contents }</td>
		</tr>
	</table>
	<br>
	
	<a href="updateForm.do?bdNo=${board.bdNo}">글수정</a>
	<a href="deleteAction.do?bdNo=${board.bdNo}">글삭제</a>
</body>
</html>